package test;

import codingfactory.rpgconsole.enemy.Enemy;
import codingfactory.rpgconsole.hero.Hero;
import org.junit.*;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class HeroTest {

	Hero hero;
	Enemy enemy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Avant le démarrage");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Après tous les tests");
	}

	@Before
	public void setUp() throws Exception {
		hero = new Hero("Jaina Portvaillant");
		enemy = new Enemy("méchant", 2);
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	}

	@Test
	public void testHeroLevelUp() throws Exception {
		Hero hero2 = new Hero("Jaina 2");
		hero2.levelUp();
		Assert.assertTrue(hero.getLevel()+1 == hero2.getLevel());
	}

	@Test
	public void testHeroProperties() throws Exception {
		assertThat(hero, hasProperty("name"));
		assertThat(hero, hasProperty("level"));
		assertThat(hero, hasProperty("hp"));
		assertThat(hero, hasProperty("atk"));

		assertThat(hero, hasProperty("name", is("Jaina Portvaillant")));

	}

	@Test
	public void testHeroRandom() throws Exception {
		ArrayList array = new ArrayList();
		int hp = 0;
		for (int i = 0; i < 5; i++) {
			Enemy enemy2 = new Enemy("méchant", 2);
			hero.attack(enemy);
			array.add(enemy.getHp());

		}
	}




	@Test
	public void testHeroAttack() throws Exception {
		int hp = enemy.getHp();
		hero.attack(enemy);
		Assert.assertTrue( hp > enemy.getHp());
	}

}
