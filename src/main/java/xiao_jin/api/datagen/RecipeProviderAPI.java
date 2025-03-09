package xiao_jin.api.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

/**
 * @author 尽
 * @apiNote 配方数据生成器
 */
public abstract class RecipeProviderAPI extends RecipeProvider {
    protected RecipeProviderAPI(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected abstract void buildRecipes();
}
