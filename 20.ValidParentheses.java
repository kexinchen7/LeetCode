// solution 1, use stack

    public boolean isValid(String s) {
        if(s==null || s.length()==0)
            return true;
        
        Stack<Character> stk = new Stack<Character>();
        for(int i=0; i<s.length(); i++)
        {
            char cur = s.charAt(i);
            if(cur == ']' || cur == '}' || cur==')')
            {
                if(stk.isEmpty())   return false;
                char last = stk.pop();
                if(last == '[' && cur == ']' || last == '{' && cur == '}' ||last == '(' && cur == ')')
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(cur == '{' || cur == '(' || cur=='[')
                    stk.push(cur);
            }
        }
        return stk.empty();
    }

// solution 2 - HashMap
    public boolean isValid(String s) {
    	HashMap<Character, Character> map = new HashMap<Character, Character>();
    	map.put('[', ']');
    	map.put('(', ')');
    	map.put('{', '}');

    	Stack<Character> stack = new Stack<Character>();

    	for(int i=0; i<s.length(); i++)
    	{
    		char cur = s.charAt(i);
    		if(map.keySet().contains(cur))
    		{
    			stack.push(cur);
    		}
    		else if(map.values().contains(cur))
    		{
    			if(!stack.empty() && map.get(stack.peek()) == cur)
    			{
    				stack.pop();
    			}
    			else
    			{
    				return false;
    			}
    		}
    	}
    	return stack.empty();
    }
