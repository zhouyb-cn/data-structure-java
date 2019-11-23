import java.util.Arrays;

class Heap {

    // 上浮调整堆 把新加入的点上浮到合适位置
    public void upAdjust(int[] nums) {
        int childIndex = nums.length - 1;
        int insertNum = nums[childIndex];
        // int insertNum = nums[nums.length - 1];
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0 && insertNum < nums[parentIndex]) {
            nums[childIndex] = nums[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        nums[childIndex] = insertNum;
    }

    // 将堆的所有父节点下沉到合适位置
    public void downAdjust(int[] nums, int parentIndex) {
        int temp = nums[parentIndex];
        int length = nums.length;
        // 左边节点索引
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            // 有右边节点情况
            if (childIndex + 1 < length && nums[childIndex] > nums[childIndex + 1]) {
                childIndex++;
            }

            if (temp < nums[childIndex]) {
                break;
            }

            nums[parentIndex] = nums[childIndex];
            parentIndex = childIndex;
            childIndex = (parentIndex * 2) + 1;
        }

        nums[parentIndex] = temp;

    }

    public void buildHeap(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            downAdjust(nums, i);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] nums = {1,3,2,6,5,7,8,9,10,0};
        heap.upAdjust(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{7,1,3,10,5,2,8,9,6};
        heap.buildHeap(nums);
        System.out.println(Arrays.toString(nums));
    }
}