package day05;

import org.junit.Test;

public class C01_Notasyon_Annotation {

    // Javadaki gibi selenium'da da belirli islevleri yapan methodlar olusturabiliriz.
    // Ancak bu methodlar cagirilmadikca CALISMAZLAR

    public void ilkTestMethod(){
        System.out.println("ilk test methodu");
    }
    // JUnit ile anotation kullanarak siradan methodlari test methoduna donusturebiliriz.
    // Bir test methodu bagimsiz olarak calisabilen test yapmamiza imkan verir.
    // test annotation sayesinde main main method mecburiyeti rtadan kalkar.
    @Test // anntotation icin @ yazmam gerekir.
    public void notasyonluIlkTestMethod(){
        System.out.println("notasyonlu ilk test methodu");
    }

}
