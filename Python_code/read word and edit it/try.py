import re
import docx
import readDocx


def RemoveLeadingSpaces(Str):
    """
    Replace space plus symbol into a single symbol
    """
    Regex = re.compile(r"( )([，。；‘“,.\'\"-+=*/（）()])")
    return Regex.sub(r"\2", Str)


def SpaceAfterSymbol(Str):
    """
    Space after replacement symbol
    """
    Regex1 = re.compile(r"([，。；‘“,.\'\"-+=*/（）()])(  )")
    Regex2 = re.compile(r"([，。；‘“,.\'\"-+=*/（）()])([^ ])")
    Str = Regex1.sub(r"\1" + " ", Str)
    return Regex2.sub(r"\1 \2", Str)


if __name__ == '__main__':
    demo = readDocx.getText('demo.docx')    #demo.docx为文件名，可以按自己需求修改
    demo = RemoveLeadingSpaces(demo)
    demo = SpaceAfterSymbol(demo)
    doc = docx.Document()
    doc.add_paragraph(demo)
    doc.save('result.docx')     #文件名保存为result.docx，可以按自己需求修改


