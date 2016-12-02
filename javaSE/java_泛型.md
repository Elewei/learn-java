
##1. 什么要使用泛型程序设计？
泛型程序设计（Generic programming）编写的代码可以被很多不同类型的对象所重用。

问题：

	public class ArrayList {
		public Object get(int i) {...}
		public void add(Object o) {..}
		private Object[] elementData;
	}

	ArrayList files = new ArrayList();
	...
	String filename = (String) names.get(0);
	files.add(new File("..."));


泛型提供一个类型参数（type parameters） ,使得程序具有更好的可读性和安全性。

ArrayList类有一个类型参数用来指元素的类型：

    ArrayList<String> files = new ArrayList<String>();

##2. 泛型类定义
一个泛型类就是具有一个或多个类型变量的类。

    public class Pair<T> {
    	public Pair() {first=null; second=null;}
    	public Pair(T first, T second) {this.first=first; this.second=second;}
    	
    	public T getFirst() {return first;}
    	public T getSecond() {return second;}
    
    	public void setFirst(T newValue) {first = newValue;}
    	public void setSecond(T newValue) {second=newValue;}
    
    	private T first;
    	private T second;
    }







