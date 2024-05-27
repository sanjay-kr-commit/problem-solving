<h2><a href="https://leetcode.com/problems/daily-temperatures">Daily Temperatures</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an array of integers <code>temperatures</code> represents the daily temperatures, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is the number of days you have to wait after the</em> <code>i<sup>th</sup></code> <em>day to get a warmer temperature</em>. If there is no future day for which this is possible, keep <code>answer[i] == 0</code> instead.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> temperatures = [73,74,75,71,69,72,76,73]
<strong>Output:</strong> [1,1,4,2,1,1,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,40,50,60]
<strong>Output:</strong> [1,1,1,0]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,60,90]
<strong>Output:</strong> [1,1,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
	<li><code>30 &lt;=&nbsp;temperatures[i] &lt;= 100</code></li>
</ul>

# Solution

<p><strong class="example">Brute Force :</strong></p>

So,
the simplest way of solving this question is to use brute force,
i.e, do as question say which is to look for the next greater number ,
using a while loop

Time Complexity : O(N^2) 

<p><strong class="example">Brute Force :</strong></p>

Because we are looking for next greater element, instead of iteratively looking 
for the element instead we can simple keep track of it using a variable, and iterate it from 
right to left so if a hotter day appear we know it no hotter element exist to the right and we can 
change the hostest day to current day, if not we can try looking for more hotter day, to thr right neighbour 
element if it's isn't hotter we can iterative add it's day count to the loop until we reach rightmost element

Time Complexity : O(N)
