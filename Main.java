class Main {
  /*
    The Main class integrates all of the other classes for a functional and interactive encryption.
  */
    public static void main(String[] args) {
    System.out.println("\nTest Bifid encrypt\n");
    
    String str = "defend the east wall of the castle";


    Phrase q = new Phrase(str);

    System.out.println("Testing Stock PS"); System.out.println();
    String[][] stockPS = q.getStockPS();
    for(int r = 0; r < stockPS.length; r++)
    {
      for(int c = 0; c < stockPS[r].length; c++)
      {
        System.out.print(stockPS[r][c]);
      }
      System.out.println();
    }
        
    System.out.println("Original: " + str);
    System.out.println();
    System.out.println("Encrypting...");
    System.out.println();
    
    int fracSize = 5;
    String enc = q.encrypt(fracSize);
  
    System.out.println("Expected: ffyhmkhycpliashadtrlhcchlblr" ); 
    System.out.println("Result  : " + enc);
    
  }
}
