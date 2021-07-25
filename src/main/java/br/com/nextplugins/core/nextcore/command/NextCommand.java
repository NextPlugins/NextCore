package br.com.nextplugins.core.nextcore.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@CommandAlias("next")
public final class NextCommand extends BaseCommand {

    private final JavaPlugin plugin;

    public NextCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Default
    @CommandPermission("nextcore.command.next")
    @Description("Lista todos os plugins feitos pela NextPlugins.")
    public void handle(CommandSender sender) {
        final @NotNull Plugin[] plugins = plugin.getServer().getPluginManager().getPlugins();

        final Set<String> nextPlugins = Arrays.stream(plugins)
                .filter(serverPlugin -> serverPlugin.getDescription().getName().contains("Next"))
                .map(serverPlugin -> serverPlugin.getDescription().getName())
                .collect(Collectors.toSet());

        final String nextPluginsList = String.join("&7,&f ", nextPlugins);

        messagesWithSpaces(sender,
                "&b&lNextPlugins",
                "",
                "&aPlugins ativos: &f" + nextPluginsList
        );
    }

    private void messagesWithSpaces(CommandSender sender, String... messages) {
        sender.sendMessage("");

        for (String message : messages) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }

        sender.sendMessage("");
    }

}
