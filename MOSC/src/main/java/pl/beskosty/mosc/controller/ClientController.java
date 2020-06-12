package pl.beskosty.mosc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.beskosty.mosc.entity.Client;
import pl.beskosty.mosc.service.ClientService;

/**
 *
 * @author Przemek
 */
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    
    @GetMapping("showCreateClientForm")
    public String createClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);

        return "/clients/create-client";
    }

    @PostMapping("createClientAction")
    public String createClient(@ModelAttribute("client") Client client) {
        clientService.createClient(client);

        return "redirect:/showClientsForm";
    }

    @GetMapping("showClientsForm")
    public String clientsForm(Model model) {
        List<Client> allClients = clientService.getClients();
        List<Client> activeClients = prepareActiveClients(allClients);

        model.addAttribute("allClients", allClients);
        model.addAttribute("activeClients", activeClients);

        return "/clients/clients";
    }

    @GetMapping("showUpdateClientForm")
    public String updateClientForm(@RequestParam("clientId") int id, Model model) {
        Client client = clientService.getClient(id);
        model.addAttribute("client", client);

        return "/clients/create-client";
    }

    @GetMapping("deleteClientAction")
    public String deleteClient(@RequestParam("clientId") int id, Model model) {
        clientService.deactivateClient(id);

        return "redirect:/showClientsForm";
    }

    /**
     * Based on the parameter, the function prepares a list of Clients with an
     * active status.
     *
     * @param allClients
     * @return List with only active Clients. Return new ArrayList if list is
     * empty or null.
     */
    private List<Client> prepareActiveClients(List<Client> allClients) {
        if (allClients == null || allClients.isEmpty()) {
            return new ArrayList<>();
        }
        return allClients
                .stream()
                .filter(c -> c.isActive())
                .collect(Collectors.toList());
    }

}
