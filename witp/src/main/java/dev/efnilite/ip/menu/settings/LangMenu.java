package dev.efnilite.ip.menu.settings;

import dev.efnilite.ip.config.Locales;
import dev.efnilite.ip.menu.Menus;
import dev.efnilite.ip.player.ParkourPlayer;
import dev.efnilite.ip.util.Util;
import dev.efnilite.vilib.inventory.PagedMenu;
import dev.efnilite.vilib.inventory.item.Item;
import dev.efnilite.vilib.inventory.item.MenuItem;
import dev.efnilite.vilib.util.Unicodes;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class LangMenu {

    /**
     * Opens the language menu
     *
     * @param   user
     *          The ParkourPlayer instance
     */
    public void open(ParkourPlayer user) {
        if (user == null) {
            return;
        }

        // init menu
        PagedMenu style = new PagedMenu(3, Locales.getString(user.getLocale(), "settings.lang.name", false));

        List<MenuItem> items = new ArrayList<>();
        for (String lang : Locales.getLocales().keySet()) {
            Item item = new Item(Material.PAPER, "<#238681><bold>" + Locales.getString(lang, "name", false));

            items.add(item
                    .glowing(user.getLocale().equals(lang))
                    .click(event -> {
                        user.setLocale(lang);
                        user._locale = lang;
                        Menus.SETTINGS.open(event.getPlayer());
                    }));
        }

        style
                .displayRows(0, 1)
                .addToDisplay(items)

                .nextPage(26, new Item(Material.LIME_DYE, "<#0DCB07><bold>" + Unicodes.DOUBLE_ARROW_RIGHT) // next page
                        .click(event -> style.page(1)))

                .prevPage(18, new Item(Material.RED_DYE, "<#DE1F1F><bold>" + Unicodes.DOUBLE_ARROW_LEFT) // previous page
                        .click(event -> style.page(-1)))

                .item(22, Locales.getItem(user.getLocale(), "other.close")
                        .click(event -> Menus.SETTINGS.open(event.getPlayer())))

                .fillBackground(Util.isBedrockPlayer(user.player) ? Material.AIR : Material.LIGHT_BLUE_STAINED_GLASS_PANE)
                .open(user.player);
    }

}
