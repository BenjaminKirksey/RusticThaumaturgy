package com.github.voxelfriend.rusticthaumaturgy.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RTCrushingTubRecipe {

	protected ItemStack input;
	protected ItemStack byproduct;
	protected FluidStack output;
	
	public RTCrushingTubRecipe(FluidStack out, ItemStack in) {
		this(out, in, ItemStack.EMPTY);
	}
	
	public RTCrushingTubRecipe(FluidStack out, ItemStack in, ItemStack by) {
		this.input = in;
		this.output = out;
		this.byproduct = by;
	}
	
	public boolean matches(ItemStack in) {
		return (in.getItem().equals(this.input.getItem()) && in.getMetadata() == this.input.getMetadata());
	}
	
	public ItemStack getInput() {
		return this.input.copy();
	}
	
	public FluidStack getResult() {
		if (this.output == null || this.output.getFluid() == null) return null;
		return FluidRegistry.getFluidStack(this.output.getFluid().getName(), this.output.amount);
	}
	
	public ItemStack getByproduct() {
		return this.byproduct.copy();
	}
	
}