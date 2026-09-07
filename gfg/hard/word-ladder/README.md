# Shortest Transformation Length in a Word List

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given two distinct words  **s**  and  **e**, and a list of unique words  **words[]**, where all words have the same length, find the length of the  **shortest**  transformation sequences from start to end.

A valid transformation sequence must satisfy the following conditions:

- Only one character can be changed in each transformation.
- Every transformed word must exist in words[], including e.
- All words consist only of lowercase English letters.
- s may or may not be present in words[].

Return the length of the shortest transformation sequence from s to e. If no such sequence exists, return **0**.

 **Examples:** 

```
Input: words[] = ["des", "der", "dfr", "dgt", "dfs"], s = "der", e = "dfs"
Output: 3
Explanation: The length of the shortest transformation sequence from "der" to "dfs" is 3 i.e "der" -> "dfr" -> "dfs".

```

```
Input: words = ["geek", "gefk"], s = "gedk", e = "geek", 
Output: 2
Explanation: The length of the shortest transformation sequence from "gedk" to "geek" is 2 i.e "gedk" -> "geek"
```

```
Input: words[] = ["poon", "plee", "same", "poie", "plea", "plie", "poin"], s = "toon", e = "plea",
Output: 7 
Explanation: The length of the shortest transformation sequence from "toon" to "plea" is 7 i.e., toon -> poon -> poin -> poie -> plie -> plee -> plea 
```

 **Constraints:** 
1 ≤ n ≤ 5 * 103, where n is the length of words
1 ≤ m ≤ 10, where m is the length of words[i]

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-07T17:16:47.676Z  

```java
class Solution {
    public int wordLadder(String[] words, String s, String e) {
        Set<String> set=new HashSet<>(Arrays.asList(words));
        if(!set.contains(e)){
        return 0;    
        }
        
        Queue<String> q=new LinkedList<>();
        
        q.add(s);
        set.remove(s);
        
        int level=1;
        while(!q.isEmpty()){
            
            int size=q.size();
          for(int j=0;j<size;j++){
            String word=q.poll();
            
            if(word.equals(e)){
                return level;
            }
            
          char[] arr=word.toCharArray();
          
            for(int i=0;i<word.length();i++){
                char original=arr[i];
                
                
                for(char ch='a';ch<='z';ch++){
                    if(original==ch){
                        continue;
                    }
                    
                    arr[i]=ch;
                    String newword=new String(arr);
                    if(set.contains(newword)){
                        q.add(newword);
                        set.remove(newword);
                    }
                }
            arr[i]=original;
            }
          }
                level++;
        }
        return 0;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/word-ladder/1)