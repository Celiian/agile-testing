package test.functional;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class FunctionalTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
	    	// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	@Test
    public void testHomepage() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/");
		assertEquals( "Meetup - Nous sommes ce que nous faisons", driver.getTitle());
        WebElement element = driver.findElement(By.cssSelector("meta[name='description']"));
		assertEquals("Trouvez des événements Meetup pour passer plus de temps à faire ce qui compte pour vous. Ou créez votre propre groupe et rencontrez des personnes près de chez vous qui partagent vos centres d'intérêt.", element.getAttribute("content"));
        WebElement h1 = driver.findElement(By.cssSelector("h1"));
        assertEquals("Meetup célèbre 20 années de liens authentiques", h1.getText());
        assertEquals("Quoi que vous recherchiez cette année, vous pourrez le trouver sur Meetup. Depuis 20 ans, les gens se tournent vers Meetup pour faire des rencontres, nouer des amitiés, trouver de l'aide, développer une entreprise et vivre leurs passions. Des milliers d'événements ont lieu chaque jour. Rejoignez l'aventure.",  driver.findElement(By.cssSelector("h1 + p")).getText());
        WebElement fonctionnement = driver.findElement(By.cssSelector("h2"));
        List<WebElement> buttons = driver.findElements(By.cssSelector("a[href*='register']"));
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getCssValue("background-color").contains("rgba(0, 130, 148, 1)")){
                WebElement button = buttons.get(i);
                System.out.println(button.getText());
                assertTrue(button.getText().contains("Rejoindre Meetup" )) ;
                assertTrue(button.getAttribute("href").contains("https://www.meetup.com/fr-FR/register/"));
                i = buttons.size();
            }
        }
    }

    @Test
    public void testRecherche() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
