import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Guru99Test extends BaseTest{

    private final MenuPage menuPage;
    Guru99Test(){
        menuPage = new MenuPage(driver);
    }

    ConfigReader configReader = new ConfigReader("src/main/resources/menuData.properties");
    String topMenu = configReader.getProperty("top_menu");
    String subMenu = configReader.getProperty("sub_menu");
    String topSubMenu = configReader.getProperty("top_sub_menu");


    @Test
    @DisplayName("click on top & sub menu , verify the url change")
    public void testMenu() {
        String previousUrl = menuPage.getCurrentUrl();
        menuPage.selectMenuItems(topMenu, subMenu);
        assertTrue(menuPage.isSubMenuLoad(previousUrl),"verify the url change");
    }

    @Test
    @DisplayName("click on top & sub menu - send in one string , verify the url change")
    public void testMenuOneString() {
        String previousUrl = menuPage.getCurrentUrl();
        menuPage.selectMenuItems(topSubMenu);
        assertTrue(menuPage.isSubMenuLoad(previousUrl),"verify the url change");
    }

}
