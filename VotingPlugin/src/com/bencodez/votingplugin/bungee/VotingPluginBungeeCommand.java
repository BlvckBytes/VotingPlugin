package com.bencodez.votingplugin.bungee;

import com.bencodez.votingplugin.bungee.proxy.VotingPluginProxyCommand;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class VotingPluginBungeeCommand extends Command {
	private VotingPluginBungee bungee;

	public VotingPluginBungeeCommand(VotingPluginBungee bungee) {
		super("votingpluginbungee", "votingplugin.admin");
		this.bungee = bungee;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("votingplugin.admin")) {
			String result = new VotingPluginProxyCommand(bungee.getVotingPluginProxy()).execute(args);
			if (result != null) {
				sender.sendMessage(new TextComponent(result.replace("&", "�")));
			}
		} else {
			sender.sendMessage(new TextComponent("&cYou do not have permission to do this!"));
		}
	}

	public boolean isInt(String st) {
		if (st == null) {
			return false;
		}
		try {
			@SuppressWarnings("unused")
			int num = Integer.parseInt(st);
			return true;

		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
