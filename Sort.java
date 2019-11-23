import java.util.Arrays;

class Sort {

    // 冒泡排序
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,7,6,9,1,2,7};
        Sort sort = new Sort();
        sort.bubbleSort(nums);   
        System.out.println(Arrays.toString(nums));
    }
}