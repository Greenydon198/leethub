class Solution {
    public int romanToInt(String s) {
       int ss=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                if(i+1!=s.length() && s.charAt(i+1)=='V'){
                    ss+=4;i++;
                }
                else if(i+1!=s.length() && s.charAt(i+1)=='X'){
                    ss+=9;i++;
                }
                else
                    ss+=1;
            }
            else if(s.charAt(i)=='V')
                    ss+=5;
             else if(s.charAt(i)=='X'){
                if(i+1!=s.length() && s.charAt(i+1)=='L'){
                    ss+=40;i++;
                }
                else if(i+1!=s.length() && s.charAt(i+1)=='C'){
                    ss+=90;i++;
                }
                else
                    ss+=10;
            }
            else if(s.charAt(i)=='L')
                    ss+=50;
            else if(s.charAt(i)=='C'){
                if(i+1!=s.length() && s.charAt(i+1)=='D'){
                    ss+=400;i++;
                }
                else if(i+1!=s.length() && s.charAt(i+1)=='M'){
                    ss+=900;i++;
                }
                else
                    ss+=100;
                }
                else if(s.charAt(i)=='D')
                    ss+=500;
                else if(s.charAt(i)=='M')
                    ss+=1000;
        } 
        return ss;
    }
}