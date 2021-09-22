# iterator

今回はiteratorパターンを一から実装したが、実際にはjava.util.ArrayListにはiterator()メソッドが元々ある。つまりjava.util.ArrayListはBookShelfやBookShelfIteratorを実装する手間を省かせてくれる。
java.util.ArrayListのiterator()メソッドを使えば、今回の機能を実装するのに必要になるのは
- Book.java
- ExecuteIterator.java

の２つだけになる。