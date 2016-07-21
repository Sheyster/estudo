package br.com.manipulacaostring;

import java.util.SortedMap;
import java.util.TreeMap;

public class Teste
{

  public static void main(String[] args)
  {
    double[] notas = { 8, 9, 5, 3, 9, 6, 6.5, 9 };
    SortedMap<Double, Integer> doces = new TreeMap<Double, Integer>();

    for (double n : notas)
    {
      if (!doces.containsKey(n))
      {
        doces.put(n, Integer.valueOf(1));
      }
      else
      {
        Integer v = doces.get(n) + 1;
        doces.put(n, v);
      }
    }

    int totalDoces = 0;
    int qtdeDoces = 1;
    for (double n : doces.keySet())
    {
      Integer v = doces.get(n);

      totalDoces += v * qtdeDoces;

      ++qtdeDoces;
    }

    System.out.println(doces);
    System.out.println(totalDoces);
  }

}
