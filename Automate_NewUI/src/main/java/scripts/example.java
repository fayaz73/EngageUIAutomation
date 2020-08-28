package scripts;

import bsh.This;

class A {
	static int i =10;
	int j =20;
	
	public void es1() {
		System.out.println(this.j);
	}
}

public class example {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.es1();
	}

}
