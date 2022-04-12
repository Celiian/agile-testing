package test;

import codingfactory.rpgconsole.enemy.Enemy;
import codingfactory.rpgconsole.hero.Hero;
import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class EnemyTest {

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
    public void testEnemyProperties() throws Exception {
        assertThat(enemy, hasProperty("name"));
        assertThat(enemy, hasProperty("hp"));

        assertThat(enemy, hasProperty("name", is("méchant")));
    }

    @Test
    public void testEnemyAttack() throws Exception {
        int hp = hero.getHp();
        enemy.attack(hero);
        Assert.assertTrue( hp > hero.getHp());


        }

}
