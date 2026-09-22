import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    //    Problem 101
    static void problem101() {
        Problem101.TreeNode root = new Problem101.TreeNode(5);
        root.left = new Problem101.TreeNode(3);
        root.right = new Problem101.TreeNode(8);
        root.left.left = new Problem101.TreeNode(1);
        root.right.left = new Problem101.TreeNode(6);
        root.right.right = new Problem101.TreeNode(10);
        Problem101 problem = new Problem101();
        int ans = problem.kthSmallest(root, 2);
        System.out.println(ans);
    }

    // Problem 99
    static void problem99() {
        Problem099 problem = new Problem099();
        Problem099.TreeNode root = new Problem099.TreeNode(2);
        root.left = new Problem099.TreeNode(1);
        root.right = new Problem099.TreeNode(1);
        root.left.left = new Problem099.TreeNode(3);
        root.right.left = new Problem099.TreeNode(1);
        root.right.right = new Problem099.TreeNode(5);
        System.out.println("Good Node : " + problem.goodNodes(root));
    }

    // Problem 98
    static void problem98() {
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}};
        Problem098 problem = new Problem098();
        var node = problem.construct(grid);
        node = node.topRight;
        System.out.println("Root : " + node);
        System.out.println("Top Left : " + node.topLeft);
        System.out.println("Top Right : " + node.topRight);
        System.out.println("Bottom Left : " + node.bottomLeft);
        System.out.println("Bottom Right : " + node.bottomRight);
    }

    // Problem 83
    static void problem83() {
        Problem083 problem = new Problem083();
        Problem083.ListNode node1 = new Problem083.ListNode(1);
        Problem083.ListNode node2 = new Problem083.ListNode(2);
        Problem083.ListNode node3 = new Problem083.ListNode(3);
        Problem083.ListNode node4 = new Problem083.ListNode(4);
        Problem083.ListNode node5 = new Problem083.ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1 = problem.reverseKGroup(node1, 5);
        printLinkedList(node1);
    }

    static void printLinkedList(Problem083.ListNode head) {
        var temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Problem 82
    static void problem82() {
        Problem082 problem = new Problem082();
        Problem082.ListNode[] nodeArray = getLinkedListArray();
        for (var node : nodeArray)
            printLinkedList(node);
        Problem082.ListNode headMerged = problem.mergeKLists(nodeArray);
        printLinkedList(headMerged);
    }

    static Problem082.ListNode[] getLinkedListArray() {
        int[] gaps = {1, 2, 3, 4};
        int[] sizes = {2, 3, 3, 4};
        Problem082.ListNode[] nodeArray = new Problem082.ListNode[4];
        for (int i = 0; i < 4; i++) {
            int size = sizes[i];
            int gap = gaps[i];
            Problem082.ListNode head = new Problem082.ListNode(gap);
            Problem082.ListNode temp = head;
            for (int j = 1; j < size; j++) {
                temp.next = new Problem082.ListNode(gap * (j + 1));
                temp = temp.next;
            }
            nodeArray[i] = head;
        }
        return nodeArray;
    }

    private static void printLinkedList(Problem082.ListNode head) {
        var temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Problem 81
    static void problem81() {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
        cache.put(3, 50);
        cache.put(4, 50);
        cache.put(5, 50);
        cache.put(6, 50);
    }

    // Problem 80
    static void problem80() {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear()); // return 3
        System.out.println(myCircularQueue.isFull()); // return True
        System.out.println(myCircularQueue.deQueue()); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear()); // return 4
    }

    // Problem 79
    static void problem79() {
        Problem079 problem = new Problem079();
        Problem079.ListNode head = new Problem079.ListNode(1);
        Problem079.ListNode node = head;
        for (int i = 2; i <= 7; i++) {
            node.next = new Problem079.ListNode(i);
            node = node.next;
        }
        Problem079.ListNode newHead = problem.reverseBetween(head, 1, 7);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    // Problem 78
    static void problem78() {
        Problem078 problem = new Problem078();
        int dup = problem.findDuplicate(new int[]{1, 2, 3, 4, 2});
        System.out.println(dup);
    }

    // Problem 77
    static void problem77() {
        Problem077 problem = new Problem077();
        // 123 + 426 = 549 -> 3-2-1 + 6-2-4 = 9-4-5
        Problem077.ListNode node11 = new Problem077.ListNode(9);
        Problem077.ListNode node12 = new Problem077.ListNode(9);
        Problem077.ListNode node13 = new Problem077.ListNode(9);
        Problem077.ListNode node14 = new Problem077.ListNode(9);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        printLinkedList(node11);
        Problem077.ListNode node21 = new Problem077.ListNode(0);
        Problem077.ListNode node22 = new Problem077.ListNode(9);
        Problem077.ListNode node23 = new Problem077.ListNode(9);
        node21.next = node22;
        node22.next = node23;
        printLinkedList(node21);
        var nodeK = problem.addTwoNumbers(node11, node21);
        printLinkedList(nodeK);
    }

    static void printLinkedList(Problem077.ListNode node) {
        while (node != null) {
            System.out.print(node.val + "-> ");
            node = node.next;
        }
        System.out.println();
    }

    // Problem 76
    static void problem76() {
        Problem076.Node node0 = new Problem076.Node(3);
        Problem076.Node node1 = new Problem076.Node(7);
        Problem076.Node node2 = new Problem076.Node(4);
        Problem076.Node node3 = new Problem076.Node(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node0.random = null;
        node1.random = node3;
        node2.random = node0;
        node3.random = node1;
        printLinkedList(node0);
        Problem076 problem = new Problem076();
        Problem076.Node newhead = problem.copyRandomList(node0);
        printLinkedList(newhead);
    }

    static void printLinkedList(Problem076.Node node) {
        while (node != null) {
            System.out.print(node.val + "(" + node.hashCode() + ") -> ");
            node = node.next;
        }
        System.out.println();
    }

    // Problem 75
    static void problem75() {
        Problem075 problem = new Problem075();
        Problem075.ListNode head = new Problem075.ListNode(1);
        Problem075.ListNode node = head;
        for (int i = 2; i <= 10; i++) {
            node.next = new Problem075.ListNode(i);
            node = node.next;
        }
        problem.removeNthFromEnd(head, 2);
    }

    // Problem 74
    static void problem74() {
        Problem074.ListNode head = new Problem074.ListNode(1);
        Problem074.ListNode node = head;
        for (int i = 2; i <= 10; i++) {
            node.next = new Problem074.ListNode(i);
            node = node.next;
        }
        Problem074 problem = new Problem074();
        problem.reorderList(head);
    }

    // Problem 73
    static void problem73() {
        MountainArray mArr = new MountainArrayImpl(new int[]{1, 2, 3, 10, 8, 7, 6, 5, 3});
        Problem073 problem = new Problem073();
        int mEle = problem.findInMountainArray(8, mArr);
        System.out.println(mEle);
    }

    // Problem 69
    static void problem69() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("alice", "happy", 1); // store the key "alice" and value "happy" along with timestamp = 1.
        System.out.println(timeMap.get("alice", 1)); // return "happy"
        System.out.println(timeMap.get("alice", 2)); // return "happy", there is no value stored for timestamp 2, thus
        // we return the value at timestamp 1.
        timeMap.set("alice", "sad", 3); // store the key "alice" and value "sad" along with timestamp = 3.
        System.out.println(timeMap.get("alice", 3));
    }

    // Problem 67
    static void problem67() {
        Problem067 problem = new Problem067();
        int nums[] = {3, 5, 6, 0, 0, 1, 2};
        System.out.println(problem.search(nums, 4));
    }

    // Problem 66
    static void problem66() {
        Problem066 problem = new Problem066();
        int[] nums = {2, 3, 4, 1};
        int r = problem.findMin(nums);
        System.out.println(r);
    }

    // Problem 65
    static void problem65() {
        Problem065 problem = new Problem065();
        int[] weights = {3, 2, 2, 4, 1, 4};
        var can = problem.shipWithinDays(weights, 3);
        System.out.println(can);
    }

    // Problem 64
    static void problem64() {
        Problem064 problem = new Problem064();
        int[] piles = {30, 11, 23, 4, 20};
        var can = problem.minEatingSpeed(piles, 6);
        System.out.println(can);
    }

    // Problem 63
    static void problem63() {
        Problem063 problem = new Problem063();
        // int[][] matrix = {{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        int[][] matrix = {{1}, {3}};
        boolean doesExist = problem.searchMatrix(matrix, 2);
        System.out.println(doesExist);
    }

    // Problem 62
    static void problem62() {
        Problem062 problem = new Problem062();
        var sqrt = problem.mySqrt(1073741824);
        System.out.println(sqrt);
    }

    // Problem 61
    static void problem61() {
        Problem061 problem = new Problem061();
        problem.setRandomLimit(2147483647);
        System.out.println(problem.guessNumber(2147483647));
    }

    // Problem 60
    static void problem60() {
        Problem060 problem = new Problem060();
        int idx = problem.searchInsert(new int[]{-1, 0, 2, 4, 6, 8}, -5);
        System.out.println(idx);
    }

    // Problem 59
    static void problem59() {
        Problem059 problem = new Problem059();
        int idx = problem.search(new int[]{-1, 0, 2, 4, 6, 8}, 0);
        System.out.println(idx);
    }

    // Problem 58
    static void problem58() {
        Problem058 problem = new Problem058();
        int max = problem.largestRectangleArea(new int[]{2, 2, 5, 6, 2, 3});
        System.out.println(max);
    }

    // Problem 57
    static void problem57() {
        FreqStack stk = new FreqStack();
        stk.push(5);
        stk.push(7);
        stk.push(5);
        stk.push(7);
        stk.push(4);
        stk.push(5);
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }

    // Problem 54
    static void problem54() {
        Problem054 problem = new Problem054();
        int fleets = problem.carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3});
        System.out.println(fleets);
    }

    // Problem 53
    static void problem53() {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80)); // return 1
        System.out.println(stockSpanner.next(60)); // return 1
        System.out.println(stockSpanner.next(70)); // return 2
        System.out.println(stockSpanner.next(60)); // return 1
        System.out.println(stockSpanner.next(75)); // return 4, because the last 4 prices
    }

    // Problem 52
    static void problem52() {
        Problem052 problem = new Problem052();
        // var ans = problem.dailyTemperatures(new int[]{30,38,30,36,35,40,28});
        var ans = problem.dailyTemperatures(new int[]{22, 21, 20});
        for (int a : ans)
            System.out.print(a + " ");
    }

    // Problem 51
    static void problem51() {
        Problem051 problem = new Problem051();
        var ans = problem.asteroidCollision(new int[]{-1, -2, -3, -4, -5});
        for (int a : ans)
            System.out.print(a + " ");
    }

    // Problem 50
    static void problem50() {
        Problem050 problem = new Problem050();
        // int eval = problem.evalRPN(new
        // String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        int eval = problem.evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "-"});
        System.out.println(eval);
    }

    // Problem 46̥
    static void problem46() {
        Problem046 problem = new Problem046();
        System.out.println(problem.isValid("]"));
    }

    // Problem 45
    static void problem45() {
        Problem045 problem = new Problem045();
        int score = problem.calPoints(new String[]{"1", "2", "+", "C", "5", "D"});
        System.out.println(score);
    }

    // Problem 44
    static void problem44() {
        Problem044 problem = new Problem044();
        var res = problem.findClosestElements(new int[]{1, 1, 2, 3, 4, 5}, 4, -1);
        System.out.println(res);
    }

    // Problem 43
    static void problem43() {
        Problem043 problem = new Problem043();
        var ans = problem.minSubArrayLen(15, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(ans);
    }

    // Problem 42
    static void problem42() {
        Problem042 problem = new Problem042();
        int[] arr = {7157, 9172, 7262, -9146, 3087, 5117, 4046, 7726, -1071, 6011, 5444, -48, -1385, -7328, 3255, 1600,
                586, -5160, -371, -5978, 9837, 3255, -6137, 8587, -3403, 9775, 260, 6016, 9797, 3371, 2395, 6851, 2349,
                -7019, 9318, 1211, -3110, 8735, -7507, 1784, 7400, -5799, 3169, -7696, -8991, -2222, -9434, -4490, 4034,
                -831, -9656, 5488, -4395, 9339, 4104, -9058, -4072, -1172, 1758, 6878, -5570, -6380, 9550, -9389, 1411,
                2298, 3516, 551, 9196, 5215, -237, -4146, 1682, 4418, -4639, 7759, 9593};
        var result = problem.maxSlidingWindow(arr, 45);
        for (int r : result)
            System.out.print(r + " ");
    }

    // Problem 41
    static void problem41() {
        Problem041 problem = new Problem041();
        String substring = problem.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(substring);
    }

    // Problem 40
    static void problem40() {
        Problem040 problem = new Problem040();
        boolean isPermutation = problem.checkInclusion("abc", "lecaabee");
        System.out.println(isPermutation);
    }

    // Problem 39
    static void problem39() {
        Problem039 problem = new Problem039();
        int longSubstring = problem.characterReplacement("AAABABB", 1);
        System.out.println(longSubstring);
    }

    // Problem 38
    static void problem38() {
        Problem038 problem = new Problem038();
        int ans = problem.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(ans);
    }

    // Problem 37
    static void problem37() {
        Problem037 problem = new Problem037();
        int asn = problem.maxProfit(new int[]{10, 1, 5, 6, 7, 1});
        System.out.println(asn);
    }

    // Problem 36
    static void problem36() {
        Problem036 problem = new Problem036();
        int arr[] = {1};
        var isTrue = problem.containsNearbyDuplicate(arr, 1);
        System.out.println(isTrue);
    }

    // Problem 35
    static void problem35() {
        Problem035 problem = new Problem035();
        int water = problem.trap(new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1});
        System.out.println(water);
    }

    // Problem 34
    static void problem34() {
        Problem034 problem = new Problem034();
        var ans = problem.numRescueBoats(new int[]{5, 1, 4, 2}, 6);
        System.out.println(ans);
    }

    // Problem 33
    static void problem33() {
        Problem033 problem = new Problem033();
        var ans = problem.maxArea(new int[]{1, 7, 2, 5, 4, 7, 3, 6});
        System.out.println(ans);
    }

    // Problem 32
    static void problem32() {
        Problem032 problem = new Problem032();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        problem.rotate(arr, 4);
        for (int a : arr)
            System.out.print(a);
    }

    // Problem 30
    static void problem30() {
        Problem030 problem = new Problem030();
        var ans = problem.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (var ans1 : ans) {
            System.out.println(ans1);
        }
    }

    // Problem 29
    static void problem29() {
        Problem029 problem = new Problem029();
        int[] nums = new int[]{-1, 0};
        var sol = problem.twoSum(nums, -1);
        System.out.println(sol[0]);
        System.out.println(sol[1]);
    }

    // Problem 28
    static void problem28() {
        Problem028 problem = new Problem028();
        int[] arr = new int[]{2, 10, 10, 30, 30, 30};
        int k = problem.removeDuplicates(arr);
        System.out.println(k);
        for (int n : arr)
            System.out.print(n + " ");
    }

    // Problem 27
    static void problem27() {
        int[] nums1 = {0, 0};
        int m = 0;
        int[] nums2 = {1, 2};
        int n = 2;
        Problem027 problem027 = new Problem027();
        problem027.merge(nums1, m, nums2, n);
        for (int a : nums1)
            System.out.print(a + " ");
    }

    // Problem 26
    static void problem26() {
        Problem026 problem = new Problem026();
        String ans = problem.mergeAlternately("abcdef", "ab");
        System.out.println(ans);
    }

    // Problem 25
    static void problem25() {
        Problem025 problem = new Problem025();
        var isPalindrome = problem.validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu");
        System.out.println(isPalindrome);
    }

    // Problem 24
    static void problem24() {
        Problem024 problem = new Problem024();
        boolean isPalindrome = problem.isPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuc");
        System.out.println(isPalindrome);
    }

    // Problem 23
    static void problem23() {
        Problem023 problem = new Problem023();
        char[] arr = new char[]{'n', 'e', 'e', 't'};
        problem.reverseString(arr);
        for (char c : arr)
            System.out.print(c + " ");
    }

    // Problem 22
    static void problem22() {
        Problem022 problem = new Problem022();
        int ans = problem.firstMissingPositive(new int[]{-2, -1, 0});
        System.out.println(ans);
    }

    // Problem 21
    static void problem21() {
        Problem021 problem = new Problem021();
        int count = problem.subarraySum(new int[]{2, -1, 1, 2}, 2);
        System.out.println(count);
    }

    // Problem 20
    static void problem20() {
        Problem020 problem = new Problem020();
        var majorityElements = problem.majorityElement(new int[]{1, 1, 2, 2, 3, 3, 1, 2});
        System.out.println(majorityElements);
    }

    // Problem 19
    static void problem19() {
        Problem019 problem = new Problem019();
        int maxProfit = problem.maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(maxProfit);
    }

    // Problem 18
    static void problem18() {
        Problem018 problem = new Problem018();
        int longSeq = problem.longestConsecutive(new int[]{0, 3, 2, 5, 4, 6, 1, 1});
        System.out.println(longSeq);
    }

    // Problem 16
    static void problem16() {
        Problem016 problem = new Problem016();
        var finalOutput = problem.productExceptSelf(new int[]{1, 2, 4, 6});
        for (int o : finalOutput)
            System.out.print(o + " ");
    }

    // Problem 15
    static void problem15() {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    // Problem 14
    static void problem14() {
        Problem014 coderEncoder = new Problem014();
        var wordList = List.of("This", "I", "Oneday");
        String encodedText = coderEncoder.encode(wordList);
        System.out.println(encodedText);
        var decodedText = coderEncoder.decode(encodedText);
        for (String text : decodedText)
            System.out.println(text);
    }

    // Problem 13
    static void problem13() {
        Problem013 topKFrequentElements = new Problem013();
        int[] nums = {7, 7};
        int[] output = topKFrequentElements.topKFrequent(nums, 1);
        for (int e : output)
            System.out.print(e + " ");
    }

    // Problem 12
    static void problem12() {
        Problem012 sortColors = new Problem012();
        int[] colors = {1, 0, 1, 2};
        sortColors.sortColors(colors);
        for (int e : colors)
            System.out.print(e + " ");
    }

    // Problem 11
    static void problem11(String[] args) {
        Problem011 sort = new Problem011();
        int[] nums = {49, 32, 37, 31, 89, 31, 32, 32, 11, 83};
        sort.sortArray(nums);
        for (int e : nums)
            System.out.print(e + " ");
    }

    // Problem 10
    static void problem10(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(2));
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));
    }

    // Problem 9
    static void problem9() {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(5);
        myHashSet.add(100005);
        myHashSet.remove(200005);
        System.out.println(myHashSet.contains(5));
        System.out.println(myHashSet.contains(100005));
        System.out.println(myHashSet.contains(200005));
    }

    // Problem 7
    static void problem7() {
        Problem007 p7 = new Problem007();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int k = p7.removeElement(nums, val);
        System.out.println(k);
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
    }

    // Problem 6
    static void problem6() {
        Problem006 p6 = new Problem006();
        String[] ss = new String[]{"bdddddddddd", "bbbbbbbbbbc"};
        List<List<String>> groups = p6.groupAnagrams(ss);
        for (List<String> group : groups) {
            for (String w : group) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
