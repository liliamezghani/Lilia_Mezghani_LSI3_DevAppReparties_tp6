package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.ConversionImpl;
import rmiService.IConversion;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            System.out.println("Demarrage du serveur RMI");
            
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Registry RMI cree sur le port 1099");
            
            IConversion conversionService = new ConversionImpl();
            System.out.println("Service ConversionImpl cree");
            
            registry.rebind("ConversionService", conversionService);
            System.out.println("Service enregistre sous le nom ConversionService");
            
            System.out.println("Serveur RMI pret et en attente de connexions");
            System.out.println("URL: rmi://localhost:1099/ConversionService");
            System.out.println("Pour arreter le serveur, appuyez sur Ctrl+C");# Pousser le code vers GitHub
git push -u origin main
            
            // Garder le serveur actif
            while(true) {
                Thread.sleep(1000);
            }
            
        } catch (Exception e) {
            System.err.println("Erreur serveur: " + e.toString());
            e.printStackTrace();
        }
    }
}