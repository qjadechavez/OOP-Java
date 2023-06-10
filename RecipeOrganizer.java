import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Comment

public class RecipeOrganizer {
    private List<Recipe> recipes;

    public RecipeOrganizer() {
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        System.out.println("Recipe added successfully!");
    }

    public void deleteRecipe(String title) {
        Recipe recipeToDelete = findRecipe(title);
        if (recipeToDelete != null) {
            recipes.remove(recipeToDelete);
            System.out.println("Recipe deleted successfully!");
        } else {
            System.out.println("Recipe not found!");
        }
    }

    public void searchRecipe(String keyword) {
        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    recipe.getDescription().toLowerCase().contains(keyword.toLowerCase()) ||
                    recipe.getIngredients().toLowerCase().contains(keyword.toLowerCase())) {
                matchingRecipes.add(recipe);
            }
        }

        if (matchingRecipes.isEmpty()) {
            System.out.println("No matching recipes found!");
        } else {
            System.out.println("Matching recipes:");
            for (Recipe recipe : matchingRecipes) {
                recipe.displayRecipe();
                System.out.println();
            }
        }
    }

    public void displayAllRecipes() {
        System.out.println("All recipes:");
        for (Recipe recipe : recipes) {
            recipe.displayRecipe();
            System.out.println();
        }
    }

    private Recipe findRecipe(String title) {
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().equalsIgnoreCase(title)) {
                return recipe;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RecipeOrganizer recipeOrganizer = new RecipeOrganizer();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Recipe Organizer Menu:");
                System.out.println("1. Add Recipe");
                System.out.println("2. Delete Recipe");
                System.out.println("3. Search Recipe");
                System.out.println("4. Display All Recipes");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter recipe title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter recipe description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter recipe ingredients: ");
                        String ingredients = scanner.nextLine();
                        Recipe recipe = new MyRecipe(title, description, ingredients);
                        recipeOrganizer.addRecipe(recipe);
                        break;
                    case 2:
                        System.out.print("Enter the title of the recipe to delete: ");
                        String titleToDelete = scanner.nextLine();
                        recipeOrganizer.deleteRecipe(titleToDelete);
                        break;
                    case 3:
                        System.out.print("Enter a keyword to search for recipes: ");
                        String keyword = scanner.nextLine();
                        recipeOrganizer.searchRecipe(keyword);
                        break;
                    case 4:
                        recipeOrganizer.displayAllRecipes();
                        break;
                    case 5:
                        System.out.println("Exiting Recipe Organizer...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
