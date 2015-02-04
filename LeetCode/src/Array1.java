import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class Array1 {
	
	public static int removeElement(int[] A, int elem)
	{
		for(int i =0; i<A.length; i++)
		{
			if(A[i] == elem)
			{
				int n = i;
				while(n<A.length-1)
				{
					A[n] = A[n+1];
					n++;
				}
			}
		}
		
		
		System.out.println(Arrays.toString(A));

		return A.length;

	}
	
	public static int[] plusOne(int[] digits)
	{
		boolean carry = true;
		
		for(int i=digits.length-1; i>= 0; i--)
		{
			if(carry == true)
			{
				if(digits[i] == 9)
				{
					digits[i] = 0;
				}
				else
				{
					digits[i]++;
					carry = false;
				}
			}
		}
		
		if(carry == false)
		{
			return digits;
		}
		else
		{
			int[] newArr = new int[digits.length+1];
			newArr[0] = 1;
			for(int j=1; j<newArr.length; j++)
			{
				newArr[j] = digits[j-1];
			}
			return newArr;
		}
		
	}
	
	public static int removeDuplicates(int[] A)
	{
		if(A.length == 0)
		{
			return 0;
		}
		int replace = 1;
		int compare = A[0];
		for(int i=0; i<A.length; i++)
		{
			if(A[i] != compare)
			{
				A[replace] = A[i];
				replace ++;
				compare = A[i];
			}
		}
		System.out.println(Arrays.toString(A));
		return replace;
	}
	
	public static boolean isPalindrome(String s)
	{
		if(s.trim() == "" || s.trim().length() == 0)
		{
			return true;
		}
		
		int i =0;
		int j = s.length() - 1;
		s = s.toLowerCase();
		while(i != j && i<s.length()-1 && j >=0)
		{
			if((Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(j))))
			{
				if(s.charAt(i) == s.charAt(j))
				{
					i++;
					j--;
				}
				else
				{
					return false;
				}
			}
			else if(Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(j)))
			{
				if(s.charAt(i) == s.charAt(j))
				{
					i++;
					j--;
				}
				else
				{
					return false;
				}
			}
			else if(Character.isLetter(s.charAt(i)) && Character.isDigit(s.charAt(j)))
			{
				return false;
			}
			else if(Character.isLetter(s.charAt(j)) && Character.isDigit(s.charAt(i)))
			{
				return false;
			}
			else if(Character.isLetter(s.charAt(i)) == false && Character.isDigit(s.charAt(i)) == false)
			{
				i++;
			}
			else if(Character.isLetter(s.charAt(j)) == false && Character.isDigit(s.charAt(j)) == false)
			{
				j--;
			}
		}
		
		return true;	
	}
	
	public static int strStr(String haystack, String needle)
	{
		if(needle == "" || needle.trim().length() == 0)
		{
			return 0;
		}
		if(haystack.contains(needle))
		{
			for(int i=0; i<haystack.length(); i++)
			{
				if(haystack.charAt(i) == needle.charAt(0))
				{
					int k=i;
					int j=0;
					boolean flag = false;
					while(j<needle.length())
					{
						if(haystack.charAt(k) == needle.charAt(j))
						{
							k++;
							j++;
							flag = true;
						}
						else
						{
							flag = false;
							break;
						}
					}
					if(flag == true)
					{
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	public static int singleNumber(int[] A)
	{
		HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
		for(int i=0; i<A.length; i++)
		{
			if(!ht.containsKey(A[i]))
			{
				ht.put(A[i], 1);
			}
			else
			{
				int j = ht.get(A[i]);
				j++;
				ht.put(A[i], j);
			}
		}
		
		Set<Integer> keySet = ht.keySet();
		
		for(int h : keySet)
		{
			if(ht.get(h) != 3)
			{
				return h;
			}
		}
		
		return -1;
	}
	
	
	
	
	public static void main(String[] args)
	{
		System.out.println("-----Problem removeElement");
		int[] testArray = {1,2,3,4,5,2,3};
		System.out.println(removeElement(testArray, 2));
		
		System.out.println("-----Problem plusOne");
		int[] testArray2 = {9,9,9};
		System.out.println(Arrays.toString(plusOne(testArray2)));
		
		System.out.println("-----Problem removeDuplicates");
		int[] testArray3 = {1,1,2,2,3,4};
		System.out.println(removeDuplicates(testArray3));
		
		System.out.println("--------Problem isPalindrome");
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		
		System.out.println("-------Problem strStr");
		System.out.println(strStr("mississipi", "issip"));
		
		System.out.println("--------Problem singleNumber II");
		System.out.println();
		
	}
	
	

}
