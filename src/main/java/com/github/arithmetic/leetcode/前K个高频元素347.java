package com.github.arithmetic.leetcode;

import java.util.*;

/**
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author peach
 * @since 2019/6/29 下午4:20
 */
public class 前K个高频元素347 {
    /** 堆中存频率*/
    public static List<Integer> topKFrequent(int[] nums, int k) {

        //统计出现次数
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
        }


        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer,Integer> entry:
        map.entrySet()) {
            if (queue.size() < k){
                queue.add(entry);
            }else if (entry.getValue() > queue.peek().getValue()){
                queue.poll();
                queue.add(entry);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            list.add(queue.poll().getKey());
        }

        return list;

    }


    public static List<Integer> topKFrequent2(int[] nums, int k) {
        //大根堆
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        });

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
        }

        queue.addAll(map.entrySet());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll().getKey());
        }
        return list;
    }

    public static void main(String[] args) {

        List<Integer> list = topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);

        for (Integer i:
        list) {
            System.out.println(i);
        }
    }
}
