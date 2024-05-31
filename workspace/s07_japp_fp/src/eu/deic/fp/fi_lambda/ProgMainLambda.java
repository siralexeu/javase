package eu.deic.fp.fi_lambda;

import java.io.Serializable;

@FunctionalInterface
interface GreetingService{
	void say(String message);
}

@FunctionalInterface
interface MathFPI<T1, T2, T3>{
	T3 doMath(T1 a, T2 b);
}

class MathClass<E1, E2, E3> implements Serializable {
	private static final long serialVersionUID = 1L;
	private float version;
	public MathClass(float version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "MathClass [version=" + version + "]";
	}
	public E3 doMathCalculation (E1 formalParam1, E2 formalParam2, MathFPI<E1, E2, E3> formalParamObjLambdaMath) {
		E3 r = formalParamObjLambdaMath.doMath(formalParam1, formalParam2);
		return r;
	}
	
}

public class ProgMainLambda {

	public static void main(String[] args) {
		MathClass<Integer, Float, Double> objM = new MathClass<>(0.2f);
		System.out.println(objM.toString());
		MathFPI<Integer, Float, Double> objLambdaMath1 = (Integer x, Float y) ->{
			Double rL = Double.parseDouble("" + (Integer.valueOf(x) + Float.valueOf(y)) ); // sau (double)(x + y);
			return rL;
		};
		
		Double rL1 = objM.doMathCalculation(Integer.valueOf(10), Float.valueOf(15.0f) /*new Float(15.of)*/, objLambdaMath1);
		System.out.println("rL1 - objLambdaMath1 (10 + 15) = " + rL1);
		System.out.println("23 - 7 lambda approach = " + objM.doMathCalculation(Integer.valueOf(23), Float.valueOf(7.0f), ((w1, w2) -> (double)(w1 - w2)) ));
		
		GreetingService objLambdaGreetingService1 = (String msg) -> {
			System.out.println("Bonjour " + msg + "!");
		};
		objLambdaGreetingService1.say("Jean-Yves");
		objLambdaGreetingService1.say("Nicolas");
		
		GreetingService objLmbdGS2 = m -> System.out.println("Hallo " + m + "!");
		objLmbdGS2.say("Hans");
		objLmbdGS2.say("Volker");
		objLmbdGS2.say("Heide");
	}

}
