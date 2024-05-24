package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long partCount = partRepository.count();
        long productCount = productRepository.count();

        // Only add sample data if there are no parts or products in the database
        if (partCount == 0 && productCount == 0) {
            System.out.println("Inventory not found. Proceeding to load sample data.");

            // Create and save parts
            OutsourcedPart proteins = new OutsourcedPart();
            proteins.setCompanyName("BioNutrients");
            proteins.setName("Proteins");
            proteins.setInv(15);
            proteins.setPrice(2.00);
            proteins.setId(100L);
            proteins.setMinimum(1);
            proteins.setMaximum(100);
            outsourcedPartRepository.save(proteins);

            OutsourcedPart carbs = new OutsourcedPart();
            carbs.setCompanyName("EnergyFoods");
            carbs.setName("Carbs");
            carbs.setInv(30);
            carbs.setPrice(1.50);
            carbs.setId(200L);
            carbs.setMinimum(1);
            carbs.setMaximum(100);
            outsourcedPartRepository.save(carbs);

            OutsourcedPart fats = new OutsourcedPart();
            fats.setCompanyName("FatStore");
            fats.setName("Fats");
            fats.setInv(25);
            fats.setPrice(3.00);
            fats.setId(300L);
            fats.setMinimum(1);
            fats.setMaximum(100);
            outsourcedPartRepository.save(fats);

            OutsourcedPart glucose = new OutsourcedPart();
            glucose.setCompanyName("SweetEnergy");
            glucose.setName("Glucose");
            glucose.setInv(40);
            glucose.setPrice(0.75);
            glucose.setId(400L);
            glucose.setMinimum(1);
            glucose.setMaximum(100);
            outsourcedPartRepository.save(glucose);

            OutsourcedPart lactose = new OutsourcedPart();
            lactose.setCompanyName("DairyRich");
            lactose.setName("Lactose");
            lactose.setInv(20);
            lactose.setPrice(2.25);
            lactose.setId(500L);
            lactose.setMinimum(1);
            lactose.setMaximum(100);
            outsourcedPartRepository.save(lactose);

            // Retrieve and print all parts
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            // Create and save products
            Product hamburger = new Product("Hamburger", 10.99, 30);
            Product pasta = new Product("Pasta", 12.99, 25);
            Product pizza = new Product("Pizza", 14.99, 15);
            Product iceCream = new Product("Ice Cream", 5.99, 20);
            Product cake = new Product("Cake", 8.99, 20);

            productRepository.save(hamburger);
            productRepository.save(pasta);
            productRepository.save(pizza);
            productRepository.save(iceCream);
            productRepository.save(cake);


            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products"+productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts"+partRepository.count());
            System.out.println(partRepository.findAll());
        } else {
            System.out.println("Inventory already populated. No further additions will be made.");
        }
    }
}