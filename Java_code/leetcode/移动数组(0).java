public void moveZeroes(int[] nums) {
	if (nums == null || nums.length == 0)
		return;
	int index = 0;
	//一次遍历，把非零的都往前挪
	for (int i = 0; i < nums.length; i++) {
	if (nums[i] != 0)
		nums[index++] = nums[i];
	}
	//后面的都是0,
	while (index < nums.length) {
		nums[index++] = 0;
	}
}