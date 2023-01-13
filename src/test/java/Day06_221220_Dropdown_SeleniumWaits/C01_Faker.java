package Day06_221220_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {

    //Faker, degerler uretmek icin Faker Class'indan bir obje uretir ve var olan methodlari kullaniriz.

    @Test
    public void fakerExample(){
// Faker objesi olusturuyoruz.
        Faker faker=new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.avatar() = " + faker.avatar().toString());
        System.out.println("faker.aviation() = " + faker.aviation().airport());
        System.out.println("faker.backToTheFuture() = " + faker.backToTheFuture().character());
        System.out.println("faker.beer() = " + faker.beer().name());
        System.out.println("faker.artist() = " + faker.artist().name());
        System.out.println("faker.book() = " + faker.book().title());
        System.out.println("faker.business() = " + faker.business().toString());
        System.out.println("faker.cat() = " + faker.cat().name());
        System.out.println("faker.commerce() = " + faker.commerce().department());
        System.out.println("faker.company() = " + faker.company().name());
        System.out.println("faker.country() = " + faker.country().name());
        System.out.println("faker.currency() = " + faker.currency().code());
        System.out.println("faker.demographic() = " + faker.demographic().demonym());
        System.out.println("faker.date() = " + faker.date().birthday());
        System.out.println("faker.dog() = " + faker.dog().name());
        System.out.println("faker.funnyName() = " + faker.funnyName().name());
        System.out.println("faker.gameOfThrones() = " + faker.gameOfThrones().character());
        System.out.println("faker.educator() = " + faker.educator().university());
        System.out.println("faker.howIMetYourMother() = " + faker.howIMetYourMother().character());
        System.out.println("faker.idNumber() = " + faker.idNumber().valid());
        System.out.println("faker.internet() = " + faker.internet().avatar());
        System.out.println("faker.job() = " + faker.job().field());
        System.out.println("faker.medical() = " + faker.medical().diseaseName());
        System.out.println("faker.nation() = " + faker.nation().nationality());
        System.out.println("faker.number() = " + faker.number().digit());
        System.out.println("faker.phoneNumber() = " + faker.phoneNumber().phoneNumber());
        System.out.println("faker.pokemon() = " + faker.pokemon().name());
        System.out.println("faker.university() = " + faker.university().name());
        System.out.println("faker.weather() = " + faker.weather().description());
        System.out.println("faker.number().digits(7).toString() = " + faker.number().digits(7).toString());

    }
}
