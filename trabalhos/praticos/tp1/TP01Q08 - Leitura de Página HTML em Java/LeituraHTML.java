import java.io.*;
import java.nio.charset.*;
import java.net.URL;
import java.net.URLConnection;

class MyIO {

   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
   //private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

   //private static String charset = "ISO-8859-1";
   private static String charset = "UTF-8";

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

class LeituraHTML {
    public static boolean isFim(String str){
        return str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M' && str.length() == 3;
    }


   public static boolean isVogal(char c){
      return c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u'; 
   }

   
   public static void contar(String html){
    
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        int a1 = 0; // á
        int e1 = 0; // é
        int i1 = 0; // í
        int o1 = 0; // ó
        int u1 = 0; // ú
        int a2 = 0; // à
        int e2 = 0; // è
        int i2 = 0; // ì
        int o2 = 0; // ò
        int u2 = 0; // ù
        int a3 = 0; // ã
        int o3 = 0; // õ
        int a4 = 0; // â
        int e3 = 0; // ê
        int i3 = 0; // î
        int o4 = 0; // ô
        int u3 = 0; // û

        int consoante = 0;
        int br = 0;
        int table = 0;

        for(int j = 0; j < html.length(); j++){
            switch (html.charAt(j)) {
               case 'a':
                  a++; break;
               case 'e':
                  e++; break;
               case 'i':
                  i++; break;
               case 'o':
                  o++; break;
               case 'u':
                  u++; break;
               case '\u00E1': // 'á'
                  a1++; break;
               case '\u00E9': // 'é'
                  e1++; break;
               case '\u00ED': // 'í'
                  i1++; break;
               case '\u00F3': // 'ó'
                  o1++; break;
               case '\u00FA': // 'ú'
                  u1++; break;
               case '\u00E0': // 'à'
                  a2++; break;
               case '\u00E8': // 'è'
                  e2++; break;
               case '\u00EC': // 'ì'
                  i2++; break;
               case '\u00F2': // 'ò'
                  o2++; break;
               case '\u00F5': // 'õ'
                  o3++; break;
               case '\u00F9': // 'ù'
                  u2++; break;
               case '\u00E3': // 'ã'
                  a3++; break;
               case '\u00E2': // 'â'
                  a4++; break;
               case '\u00EA': // 'ê'
                  e3++; break;
               case '\u00EE': // 'î'
                  i3++; break;
               case '\u00F4': // 'ô'
                  o4++; break;
               case '\u00FB': // 'ū'
                  u3++; break;
               case '<':
                  try{
                     if(html.charAt(j + 1) == 'b' && html.charAt(j + 2) == 'r' && html.charAt(j + 3) == '>'){
                        br++;
                     }
                     else{
                        if(html.charAt(j + 1) == 't' && html.charAt(j + 2) == 'a' && html.charAt(j + 3) == 'b' && html.charAt(j + 4) == 'l' && html.charAt(j + 5) == 'e' && html.charAt(j + 6) == '>')
                           table++;
                     }
                  }catch(Exception x){
                     x.printStackTrace();
                  } 
                  break;
               
               default:
                  if(!isVogal(html.charAt(j)) && (html.charAt(j) >= 'a' && html.charAt(j) <= 'z')){
                     consoante++;
                  }
            }
        }

            consoante = consoante - (table * 3) - (br * 2); // vai tirar as consoantes que estavam dentro de <br> e <table>
            
            a = a - table; // precisa tirar a vogal a do table
            e = e - table; // precisa tirar a vogal e do table

            MyIO.print("a(" + a + ") ");
            MyIO.print("e(" + e + ") ");
            MyIO.print("i(" + i + ") ");
            MyIO.print("o(" + o + ") ");
            MyIO.print("u(" + u + ") ");
            MyIO.print("\u00E1(" + a1 + ") ");
            MyIO.print("\u00E9(" + e1 + ") ");
            MyIO.print("\u00ED(" + i1 + ") ");
            MyIO.print("\u00F3(" + o1 + ") "); // o pra frente
            MyIO.print("\u00FA(" + u1 + ") ");
            MyIO.print("\u00E0(" + a2 + ") ");
            MyIO.print("\u00E8(" + e2 + ") ");
            MyIO.print("\u00EC(" + i2 + ") ");
            MyIO.print("\u00F2(" + o2 + ") ");
            MyIO.print("\u00F9(" + u2 + ") ");
            MyIO.print("\u00E3(" + a3 + ") ");
            MyIO.print("\u00F5(" + o3 + ") ");
            MyIO.print("\u00E2(" + a4 + ") ");
            MyIO.print("\u00EA(" + e3 + ") ");
            MyIO.print("\u00EE(" + i3 + ") ");
            MyIO.print("\u00F4(" + o4 + ") ");
            MyIO.print("\u00FB(" + u3 + ") ");
            MyIO.print("consoante(" + consoante + ") ");
            MyIO.print("<br>(" + br + ") ");
            MyIO.print("<table>(" + table + ") ");
            

    }

    public static String lerHTML(String endereco){
        StringBuilder conteudo = new StringBuilder();
        String html = "";

        try{
                URL url = new URL(endereco);
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String linha = "";

                while((linha = bufferedReader.readLine()) != null){
                    conteudo.append(linha + "\n");
                }

                bufferedReader.close();        
        }
        catch(Exception e){
                e.printStackTrace();
        }

        return conteudo.toString();

    }

    public static void main(String[] args){
        
        while(true){
            String nome = MyIO.readLine();
            String endereco;

            if(isFim(nome)) {
                break;
            }

            endereco = MyIO.readLine();
            String html = lerHTML(endereco);

            contar(html);
            MyIO.println(nome);
        }


    }
}