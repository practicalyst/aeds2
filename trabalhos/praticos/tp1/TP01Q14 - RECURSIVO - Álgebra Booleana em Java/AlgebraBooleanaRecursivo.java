import java.io.*;
import java.nio.charset.*;

class MyIO {

   //private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
   private static String charset = "ISO-8859-1";

   public static void setCharset(String charset_){
      charset = charset_;
      in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
   }

   public static void print(){
   }

   public static void print(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void print(float x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void print(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(){
   }

   public static void println(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(float x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
   
   public static void println(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void printf(String formato, double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.printf(formato, x);// "%.2f"
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim().replace(",","."));
      }catch(Exception e){}
      return d;
   }

   public static double readDouble(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readDouble();
   }

   public static float readFloat(){
      return (float) readDouble();
   }

   public static float readFloat(String str){
      return (float) readDouble(str);
   }

   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }catch(Exception e){}
      return i;
   }

   public static int readInt(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readInt();
   }

   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readString();
   }

   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readLine();
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp  = (char)in.read();
      }catch(Exception e){}
      return resp;
   }

   public static char readChar(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readChar();
   }

   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";

      try{
         str = readString();
      }catch(Exception e){}

      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
            str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
            }

      return resp;
   }

   public static boolean readBoolean(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readBoolean();
   }

   public static void pause(){
      try{
         in.read();
      }catch(Exception e){}
   }

   public static void pause(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      pause();
   }
}

class AlgebraBooleanaRecursivo{

    public static String removerEspacos(String frase){
        String novaFrase = "";

        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == ' ')
                continue;
            novaFrase += frase.charAt(i);
        }

        return novaFrase;
    }

    public static boolean resolveNOT(boolean[] exp, String expr){
         boolean resultado = false;

         switch(expr.charAt(2)){
            case 'A':
               resultado = !exp[0]; 
               break;
            case 'B':
               resultado = !exp[1]; 
               break;
            case 'C':
               resultado = !exp[2]; 
               break;
            case '1':
               break;
            case '0':
               resultado = true; 
               break;
         }
         return resultado;
    }

    //d(0,1,C)
    public static boolean resolveAND(boolean[] exp, String expr){
        boolean resultado = false;

        switch(expr.charAt(2)){
               case 'A':
                  resultado = exp[0];
                  break;
               case 'B':
                  resultado = exp[1];
                  break;
               case 'C':
                  resultado = exp[2];
                  break;
               case '1':
                  resultado = true;
                  break;
               case '0':
                  resultado = false;
                  break;               
         }        


        for(int i = 4; i <= expr.length() - 1; i+=2){

            switch(expr.charAt(i)){
               case 'A':
                  resultado = resultado && exp[0];
                  break;
               case 'B':
                  resultado = resultado && exp[1];
                  break;
               case 'C':
                  resultado = resultado && exp[2];
                  break;
               case '1':
                  resultado = resultado && true;
                  break;
               case '0':
                  resultado = resultado && false;
                  break;               

            }        
        }

        return resultado;
    }
    
    //r(A,B,C)
    public static boolean resolveOR(boolean[] exp, String expr){
         boolean resultado = false;

         switch(expr.charAt(2)){
               case 'A':
                  resultado = exp[0];
                  break;
               case 'B':
                  resultado = exp[1];
                  break;
               case 'C':
                  resultado = exp[2];
                  break;
               case '1':
                  resultado = true;
                  break;
               case '0':
                  resultado = false;
                  break;               
         }        

        for(int i = 4; i <= expr.length() - 1; i+=2){

            switch(expr.charAt(i)){
               case 'A':
                  resultado = resultado || exp[0];
                  break;
               case 'B':
                  resultado = resultado || exp[1];
                  break;
               case 'C':
                  resultado = resultado || exp[2];
                  break;
               case '1':
                  resultado = resultado || true;
                  break;
               case '0':
                  resultado = resultado || false;
                  break;               

            }
        }

        return resultado;
    }

    /*
        resolve uma expressão na forma mais simples.
        
        d() = AND
        r() = OR
        t() = NOT

        exp[0] = A
        exp[1] = B
        exp[2] = C
        ...

    */
    public static boolean resolveExpr(boolean[] exp, String expr){
        
        boolean resultado = false;

        switch(expr.charAt(0)){
            case 'd': 
                resultado = resolveAND(exp, expr); 
                break;
            case 'r':
                resultado = resolveOR(exp, expr);
                break;
            case 't':
                resultado = resolveNOT(exp,expr);
                break;
            default:
                break;        
        }

        return resultado;
    }

    /*
        resolve a a expressão mais interna dentro de uma expressão booleana
        ideia: pegar o que há dentro da ultima ocorrência de '(' e a primeira de ') apos a abertura

        sempre haverá algo anterior ao primeiro parentesis, indicando o tipo da operação. 
        o ideal é também pegar isso, por isso vamos pegar um caractere anterior ao (
    */
    public static String exprInterna(boolean[] exp, String expr){
        
        int abertura = -1; 
        int ultima = -1;
        
        String interna = "";
        String novaExpr = "";

        boolean resultado = false;

        //MyIO.println("Expressao: " + expr);

        // pega o último parentesis aberto
        for(int i = 0; i < expr.length(); i++){
            if(expr.charAt(i) == '(')
                abertura = i;
        }

        // pega o primeiro parentesis fechando depois dele
        for(int i = abertura + 1; i < expr.length(); i++){
            if(expr.charAt(i) == ')'){
                ultima = i;
                break;
            }
        }

        // se não houver nenhum parentesis abrindo e fechando a expressão, ela já esta resolvida
        if(abertura == -1 && ultima == -1)
            return expr;

        // forma a expressão
        for(int i = abertura - 1; i <= ultima; i++){
            interna += expr.charAt(i);
        }

        resultado = resolveExpr(exp, interna); // obtem o valor booleano da expressao interna resolvida
        
        //MyIO.println("Expressao mais interna: " + interna);
        //MyIO.println("Resultado da interna: " + resultado);

        // tira os caracteres escritos antes da expressão
        if(interna.charAt(0) == 'r') // or
            abertura -= 2;
        else // and e not
            abertura -= 3;

        // cuida da primeira metade do array
        for(int i = 0; i < abertura; i++)
            novaExpr += expr.charAt(i);

        if(resultado == true)
            novaExpr += '1';
        else
            novaExpr += '0';

        // cuida da segunda metade da string
        for(int i = ultima + 1; i < expr.length(); i++)
            novaExpr += expr.charAt(i);
        
        return novaExpr;
    }
    

    public static int algebra(boolean[] exp,  String expr){
        
      if(expr.length() == 1){ 
         return (expr.charAt(0) == '1' ? 1 : 0); 
      }

      else {
         return algebra(exp, exprInterna(exp, expr));
      }       
    }


    public static void main(String[] args){
        while(true){
            int n = MyIO.readInt();

            if(n == 0)
                break;

            boolean[] exp = new boolean[3]; // posso criar com n, mas para evitar out of bound exception
            String expr;         

            // Faz a leitura das entradas
            for(int i = 0; i < n; i++){
                exp[i] = MyIO.readBoolean();
            }

            expr = MyIO.readLine();
            expr = removerEspacos(expr);
        
            MyIO.println(algebra(exp, expr));
        
        }


    }
}