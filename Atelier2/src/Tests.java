
public class Tests {
	static int a=42;
	int b;
	
	public static void modifier_a(){ a= a + 1;}


	public static void main(String[] args) {
		Tests obj1 = new Tests(); //creation d'une instance de classe : NOM_DE_CLASSE NOM_D_INSTANCE = new NOM_DE_CLASSE()
		Tests obj2 = new Tests();
		
		
		
		System.out.printf("sans instance : a = %d\n", Tests.a);
		
		System.out.printf("avec instance : a = %d\n", obj1.a);
		
		obj1.modifier_a();
		//on peut egalement faire Tests.modifier_a() comme il s'agit d'une methode statique
		
		obj2.modifier_a();
		System.out.printf("apres modif, sans instance : a = %d\n", obj1.a);
	}

}
