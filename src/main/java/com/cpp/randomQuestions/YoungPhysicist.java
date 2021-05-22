package com.cpp.randomQuestions;

import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

/* Built using CHelper plug-in
 * Solution By SANYAM ARORA
 */
//MY CODE STARTS HERE//

public class YoungPhysicist {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    FastReader in = new FastReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Ques solver;
    solver = new Ques();
    //int testNumber=in.nextInt();
    //while(testNumber-->0)
    solver.solve(1, in, out);
    out.close();
  }

  static class Ques {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
      int n=in.nextInt();
      //int a[][]=new int[n][3]
      int a=0,b=0,c=0;
      while(n-->0){
        a+=in.nextInt();
        b+=in.nextInt();
        c+=in.nextInt();
      }
      if(a==b&&b==c&&a==0) out.println("YES");
      else out.println("NO");
    }
  }
  static long d, x, y;
  static void extendedEuclid(long A, long B) {
    if(B == 0) {
      d = A;
      x = 1;
      y = 0;
    }
    else {
      extendedEuclid(B, A%B);
      long temp = x;
      x = y;
      y = temp - (A/B)*y;
    }
  }
  static long modInverse(long A, long M)
  {
    extendedEuclid(A,M);
    return (x%M+M)%M;
  }
  static long modPow(long x,long y,long M){
    if(y==0) return 1;
    if(y%2==0) return modPow((x*x)%M,y/2,M);
    else return (x*modPow((x*x)%M,(y-1)/2,M))%M;
  }
  static long M = (long) Math.pow(10,9)+7;
  //MY CODE END HERE//

  static class FastReader {
    private InputStream stream;
    private byte[] buf = new byte[8192];
    private int curChar;
    private int pnumChars;
    private FastReader.SpaceCharFilter filter;

    public FastReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (pnumChars == -1) {
        throw new InputMismatchException();
      }
      if (curChar >= pnumChars) {
        curChar = 0;
        try {
          pnumChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (pnumChars <= 0) {
          return -1;
        }
      }
      return buf[curChar++];
    }
    private String readLine0(){
      StringBuilder buf = new StringBuilder ();
      int c = read ();
      while (c != '\n' && c != -1){
        if (c != '\r'){
          buf.appendCodePoint (c);
        }
        c = read ();
      }
      return buf.toString ();
    }
    public String nextLine(){
      String s = readLine0 ();
      while (s.trim ().length () == 0)
        s = readLine0 ();
      return s;
    }
    public String nextLine(boolean ignoreEmptyLines){
      if (ignoreEmptyLines){
        return nextLine ();
      }else{
        return readLine0 ();
      }
    }
    public char nextCharacter(){
      int c = read ();
      while (isSpaceChar (c))
        c = read ();
      return (char) c;
    }

    public double nextDouble(){
      int c = read ();
      while (isSpaceChar (c))
        c = read ();
      int sgn = 1;
      if (c == '-'){
        sgn = -1;
        c = read ();
      }
      double res = 0;
      while (!isSpaceChar (c) && c != '.'){
        if (c == 'e' || c == 'E'){
          return res * Math.pow (10, nextInt ());
        }
        if (c < '0' || c > '9'){
          throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = read ();
      }
      if (c == '.'){
        c = read ();
        double m = 1;
        while (!isSpaceChar (c)){
          if (c == 'e' || c == 'E'){
            return res * Math.pow (10, nextInt ());
          }
          if (c < '0' || c > '9'){
            throw new InputMismatchException ();
          }
          m /= 10;
          res += (c - '0') * m;
          c = read ();
        }
      }
      return res * sgn;
    }

    public int nextInt() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c == ',') {
          c = read();
        }
        if (c < '0' || c > '9') {
          throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }
    public String next() {
      return nextString();
    }
    public int[] nextIntArray(int n) {
      int a[] = new int[n];
      for (int i = 0; i < n; i++)
        a[i] = nextInt();
      return a;
    }
    public long nextLong() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      long res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }
    public String nextString() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }
    public BigInteger nextBigInteger(){
      try{
        return new BigInteger (nextString());
      } catch (NumberFormatException e){
        throw new InputMismatchException ();
      }
    }

    public boolean isSpaceChar(int c) {
      if (filter != null) {
        return filter.isSpaceChar(c);
      }
      return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);

    }

  }
}