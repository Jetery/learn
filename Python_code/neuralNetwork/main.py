

import numpy
import scipy.special


class neuralNetwork:

    # 初始换神经网络
    def __init__(self, inputNodes, hiddenNodes, outputNodes, learningRate):
        self.iNodes = inputNodes
        self.hNodes = hiddenNodes
        self.oNodes = outputNodes

        # 简单创建方法 :
        # 创建权重矩阵  使权重范围为 (-1, 1)
        # self.weightIH = numpy.random.rand(input_nodes, hidden_nodes) - 0.5
        # self.weightHO = numpy.random.rand(hidden_nodes, output_nodes) - 0.5

        # 正太概率创建权重
        # 参数意义 :  1.正太分布中心设置为 0    2.节点数的-0.5次方    3.size
        self.weightIH = numpy.random.normal(0.0, pow(self.iNodes, -0.5), (self.hNodes, self.iNodes))
        self.weightHO = numpy.random.normal(0.0, pow(self.hNodes, -0.5), (self.oNodes, self.hNodes))

        # 设置学习率
        self.lr = learningRate

        # 设置激活函数
        self.activation_function = lambda x : scipy.special.expit(x)

    # 训练神经网络
    def train(self, inputs_list, targets_list):
        # 转化为二维数组
        train_inputs = numpy.array(inputs_list, ndmin = 2).T
        train_targets = numpy.array(targets_list, ndmin = 2).T
        # 计算 传递给隐藏层的信号
        hidden_inputs = numpy.dot(self.weightIH, train_inputs)
        # 计算 隐藏层输出的信号
        hidden_outputs = self.activation_function(hidden_inputs)
        # 计算 传递给最终输出层的信号
        final_inputs = numpy.dot(self.weightHO, hidden_outputs)
        # 计算 最终输出的信号
        final_outputs = self.activation_function(final_inputs)
        # 计算误差
        output_errors = train_targets - final_outputs
        # 将计算误差按照权重分配, 得到隐藏层误差
        hidden_errors = numpy.dot(self.weightHO.T, output_errors)
        # 更新隐藏层和输出层之间的权重
        self.weightHO += self.lr * numpy.dot((output_errors * final_outputs * (1.0 - final_outputs)),
                                        numpy.transpose(hidden_outputs))

        # 更新输入层和输出层之间的权重
        self.weightIH += self.lr * numpy.dot((hidden_errors * hidden_outputs * (1.0 - hidden_outputs)),
                                        numpy.transpose(train_inputs))
        pass

    # 计算功能
    def query(self, inputs_list):
        # 将输入列表转化为二维数组
        query_inputs = numpy.array(inputs_list, ndmin = 2).T

        # 计算 传递给隐藏层的信号
        hidden_inputs = numpy.dot(self.weightIH, query_inputs)
        # 计算 隐藏层输出的的信号
        hidden_outputs = self.activation_function(hidden_inputs)

        # 计算 传递给最终输出层的信号
        final_inputs = numpy.dot(self.weightHO, hidden_outputs)
        # 计算 最终输出层输出的信号
        final_outputs = self.activation_function(final_inputs)

        # 返回结果
        return  final_outputs



if __name__ == '__main__':
    input_nodes = 784
    hidden_nodes = 100
    output_nodes = 10

    # 设置学习率
    learning_rate = 0.3

    # 创建神经网络
    n = neuralNetwork(input_nodes, hidden_nodes, output_nodes, learning_rate)

    training_data_file = open("dataset/train.csv", 'r')
    training_data_list = training_data_file.readlines()
    training_data_file.close()

    for record in training_data_list:
        # split the record by the ',' commas
        all_values = record.split(',')
        # scale and shift the inputs
        inputs = (numpy.asfarray(all_values[1:]) / 255.0 * 0.99) + 0.01
        # create the target output values (all 0.01, except the desired label which is 0.99)
        targets = numpy.zeros(output_nodes) + 0.01
        # all_values[0] is the target label for this record
        targets[int(all_values[0])] = 0.99
        n.train(inputs, targets)
        pass




    test_data_file = open("dataset/test.csv", 'r')
    test_data_list = test_data_file.readlines()
    test_data_file.close()

    # scorecard for how well the network performs, initially empty
    scorecard = []

    # go through all the records in the test data set
    for record in test_data_list:
        # split the record by the ',' commas
        all_values = record.split(',')
        # correct answer is first value
        correct_label = int(all_values[0])
        # scale and shift the inputs
        inputs = (numpy.asfarray(all_values[1:]) / 255.0 * 0.99) + 0.01
        # query the network
        outputs = n.query(inputs)
        # the index of the highest value corresponds to the label
        label = numpy.argmax(outputs)
        # append correct or incorrect to list
        if label == correct_label:
            # network's answer matches correct answer, add 1 to scorecard
            scorecard.append(1)
        else:
            # network's answer doesn't match correct answer, add 0 to scorecard
            scorecard.append(0)
            pass

        pass

    scorecard_array = numpy.asarray(scorecard)
    #print(scorecard)
    print(scorecard_array.size)
    print("performance = ", scorecard_array.sum() / scorecard_array.size)