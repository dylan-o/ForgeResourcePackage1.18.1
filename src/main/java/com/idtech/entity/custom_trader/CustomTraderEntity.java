package com.idtech.entity.custom_trader;
import com.idtech.BaseMod;
import com.idtech.entity.EntityUtils;
import com.idtech.item.GelPickaxeItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class CustomTraderEntity extends WanderingTrader {
    public static EntityType<CustomTraderEntity> TYPE = (EntityType<CustomTraderEntity>)
            EntityType.Builder.of(CustomTraderEntity::new, MobCategory.MONSTER)
                    .build("beantrader")
                    .setRegistryName(BaseMod.MODID, "beantrader");
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);

    public CustomTraderEntity(EntityType<? extends WanderingTrader> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
    @Override
    protected void updateTrades() {
        VillagerTrades.ItemListing[] avillagertrades$itemlisting = VillagerTrades.WANDERING_TRADER_TRADES.get(1);
        VillagerTrades.ItemListing[] avillagertrades$itemlisting1 = VillagerTrades.WANDERING_TRADER_TRADES.get(2);
        if (avillagertrades$itemlisting != null && avillagertrades$itemlisting1 != null) {
            MerchantOffers merchantoffers = this.getOffers();

            ItemStack stack = new ItemStack(GelPickaxeItem.INSTANCE, 1);



            MerchantOffer customOffer = new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    stack, 10, 8, 0.02f);




            merchantoffers.add(0, customOffer);

            this.addOffersFromItemListings(merchantoffers, avillagertrades$itemlisting, 5);
            int i = this.random.nextInt(avillagertrades$itemlisting1.length);
            VillagerTrades.ItemListing villagertrades$itemlisting = avillagertrades$itemlisting1[i];
            MerchantOffer merchantoffer = villagertrades$itemlisting.getOffer(this, this.random);
            if (merchantoffer != null) {
                merchantoffers.add(merchantoffer);
            }

        }
    }
}
