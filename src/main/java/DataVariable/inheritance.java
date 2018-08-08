package DataVariable;

public class inheritance {

	// secondOne obj = new secondOne();

	public static void main(String args[]) {

		/*
		 * secondOne bbb = new secondOne(); bbb.itemOne(); bbb.itemTwo();
		 * implementInterfaces aaa = new implementInterfaces(); aaa.yesterday();
		 */

		implementInterfaces bbbb = new implementInterfaces();
		bbbb.yesterday();
	}
}

abstract class firstOne {

	abstract void itemOne();

	abstract void itemTwo();

}

class secondOne extends firstOne {

	public void itemOne() {

		System.out.println("this is the first item");
	}

	public void itemTwo() {

		System.out.println("this is the second item");
	}

}

interface myTime {

	public void yesterday();

}

interface AnotherTime extends myTime {

	public void Today();
}

class implementInterfaces implements AnotherTime {

	public void yesterday() {

		System.out.println("yet another star in the  hood");

	}

	public void Today() {
		System.out.println("this is for Today items");

	}

}
