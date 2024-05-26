<h2><a href="https://leetcode.com/problems/max-number-of-k-sum-pairs">Max Number of K-Sum Pairs</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p>

<p>In one operation, you can pick two numbers from the array whose sum equals <code>k</code> and remove them from the array.</p>

<p>Return <em>the maximum number of operations you can perform on the array</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4], k = 5
<strong>Output:</strong> 2
<strong>Explanation:</strong> Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,1,3,4,3], k = 6
<strong>Output:</strong> 1
<strong>Explanation:</strong> Starting with nums = [3,1,3,4,3]:
- Remove the first two 3&#39;s, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>

# Solution
<p><strong class="example">First Thought:</strong></p>

Because this question demands us to know the place about two number whoes sum will be k
we can either cache it which will take O(n) space or look for it which will take O(n) time
in each Look up and for n elements we'll be left with O(n^2) time complexity which is bad,
also there will be headache of maintaining wether an element is already counted or not, which
can be done by marking a counted value as negative because the range of number is always
greater than zero

<p><strong class="example">Second Thought ( The Pattern ):</strong></p>

we have two pointer l which points at zero and increases with iteration and r which point at
end, and decreases multiple time with each l iteration ,
now

If we sort this array than we can narrow down search path, because with each iteration the
value will either increase or stay constant that means the distance from i to k will decrease,
so if i-1 cannot be found till r, that also imply i won't be available at r either,
so we don't have to re iterate every element of each iteration and the whole array will be
traversed only once

<p><strong class="example">Third Thought ( optimization ):</strong></p>

We Already brought the runtime to O(n) time with O(1) space, what now. well there is one more
thing that can be done, because we know only positive number exist in array so any number which
is greater than k will produce a negative pair, which will never exist as we already know ,
so we can narrow down the element in array by only applying above operations one num which
is smaller than k, it won't change complexity of code, but it will show some improvement in
overall time when running the algo, on large data sample
