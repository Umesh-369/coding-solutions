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