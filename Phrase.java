/*
Creator: Matthew Ayoob
The Phrase class creates a message through the bifid cipher encryption
*/
class Phrase
{ String attribute;

public Phrase(String t)
{
  attribute = t;
}

public String getAtt()
{
  return attribute;
}

/**
    * creates a stock Polybius square

    * @return 2D String array
  */
public  String[][] getStockPS()
{
String[][] returnd = new String[5][5];
String[] elements = {"p", "h", "q","g", "m", "e", "a", "y", "l", "n", "o", "f", "d", "x", "k", "r", "c", "v", "s", "z", "w", "b", "u", "t", "i"};
int indexOfElements = 0;
for (int r = 0; r < returnd.length; r++)
  for (int c = 0; c < returnd[r].length; c++)
  {
   returnd[r][c] = elements[indexOfElements];
   indexOfElements++;
  }
  return returnd;
}


/**
    *  finds the first occurance of a character

    * @return integer representing index
  */
public int firstOccurance(String key, String chara)
{
for (int r = 0; r < key.length(); r++)
  {
    if (key.charAt(r)== chara.charAt(0))
    return r;
  }
  return -1;
}

/**
    * creates a custom Polybius square

    * @return 2D String array
  */
public String[][] getCustomPS(String key)
{
String[][] returnd = new String[5][5];
String[] elements = {"a", "b", "c","d", "e", "f", "g", "h", "i", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "v", "y", "z"};
 int indexOfElements = 0;
for (int r = 0; r < returnd.length; r++)
  for (int c = 0; c < returnd[r].length; c++)
  {
  if (firstOccurance(key, elements[indexOfElements]) < 0)
   returnd[r][c] = elements[indexOfElements];
   indexOfElements++;
  }
  return returnd;
}

/**
    * finds the column that holds the "needle"

    * @return integer of the column
  */
public int findCol(String needle, String[][] haystack)
{
 for ( int r = 0; r < haystack.length; r++) 
 {
   for ( int c = 0; c < haystack[r].length; c++) 
   {
     if (haystack[r][c].equals(needle))
     {
       return c;
     }
   }
 }
 return -1;
}

/**
    * finds the row that holds the "needle"

    * @return integer representing the row
  */
public int findRow(String needle, String[][] haystack)
{
 for ( int r = 0; r < haystack.length ; r++) 
 {
   for ( int c = 0; c < haystack[r].length ; c++) 
   {
     if (haystack[r][c].equals(needle))
     {
       return r;
     }
   }
 }
 return -1;
}

/**
    * encrypts the message

    * @return String representation of the encryption
  */
public String encrypt(int size)
{
  String newMessage = attribute; 
  if(newMessage.length()%2==1) 
  {
   newMessage = newMessage + "x";  
  }
  newMessage = newMessage.replace(" ", "");  

  String tempRows = "";
  String tempCols = "";
  for (int r = 0; r < newMessage.length(); r++)
    {
      tempRows += findRow(newMessage.substring(r, r+1), getStockPS()); 
      tempCols += findCol(newMessage.substring(r, r+1), getStockPS()); 
    }
  System.out.println("tempRows: " + tempRows);
  System.out.println("tempCols: " + tempCols);


  String result1 = "";

  for ( int i = 0 ; i < tempRows.length(); i = i +size) { 
    if (i+size > tempRows.length()) {
        result1 += tempRows.substring(i,tempRows.length());
        result1 += tempCols.substring(i,tempRows.length());
    }
    else {
        result1 += tempRows.substring(i,i +size);
        result1 += tempCols.substring(i,i +size);
    }
  }

  System.out.println("result1: " + result1);
  String finalS = "";
  String[][] myPS;
  myPS = getStockPS();
  for (int i = 0; i <  result1.length() -1; i = i+2)
  {
  finalS += myPS[Integer.parseInt(result1.substring(i, i+1))][Integer.parseInt(result1.substring(i+1, i +2))]; 
  }
  return finalS;
}

}
