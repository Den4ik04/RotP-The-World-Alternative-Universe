package com.august_dr.rotp_theworld.client.render.entity.model.stand;

import com.august_dr.rotp_theworld.action.stand.THEWORLDTimeStop;
import com.august_dr.rotp_theworld.entity.stand.stands.THEWORLDEntity;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPoseTransition;
import com.github.standobyte.jojo.client.render.SlopeModelBox;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPoseTransitionMultiple;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import net.minecraft.client.renderer.model.ModelRenderer;
public class THEWORLDModel extends HumanoidStandModel<THEWORLDEntity> {

	private final ModelRenderer headpiece;
	private final ModelRenderer slopeNew;
	private final ModelRenderer faceRight;
	private final ModelRenderer faceLeft;
	private final ModelRenderer heartSmallHead;
	private final ModelRenderer smallHeartCube4;
	private final ModelRenderer smallHeartCube5;
	private final ModelRenderer smallHeartCube6;
	private final ModelRenderer smallHeartCube2;
	private final ModelRenderer smallHeartCube3;
	private final ModelRenderer torso_r1;
	private final ModelRenderer torso_r2;
	private final ModelRenderer torso_r3;
	private final ModelRenderer torso_r4;
	private final ModelRenderer tube1;
	private final ModelRenderer tube2;
	private final ModelRenderer heartLargeAbdomen;
	private final ModelRenderer largeHeartCube3;
	private final ModelRenderer largeHeartCube2;
	private final ModelRenderer heartLeftArm;
	private final ModelRenderer heartCube4;
	private final ModelRenderer heartCube5;
	private final ModelRenderer heartCube6;
	private final ModelRenderer heartCube9;
	private final ModelRenderer heartCube10;
	private final ModelRenderer leftForeArm_r1;
	private final ModelRenderer leftForeArm_r2;
	private final ModelRenderer leftForeArm_r3;
	private final ModelRenderer leftForeArm_r4;
	private final ModelRenderer leftForeArm_r5;
	private final ModelRenderer heartRightArm;
	private final ModelRenderer heartCube1;
	private final ModelRenderer heartCube2;
	private final ModelRenderer heartCube3;
	private final ModelRenderer heartCube7;
	private final ModelRenderer heartCube8;
	private final ModelRenderer rightForeArm_r1;
	private final ModelRenderer rightForeArm_r2;
	private final ModelRenderer rightForeArm_r3;
	private final ModelRenderer rightForeArm_r4;
	private final ModelRenderer rightForeArm_r5;
	private final ModelRenderer heartLeftLeg;
	private final ModelRenderer heartRightLeg;

	public THEWORLDModel() {
		super();

		addHumanoidBaseBoxes(null);
		texWidth = 128;
		texHeight = 128;

		headpiece = new ModelRenderer(this);
		headpiece.setPos(0.0F, -2.0F, -5.3F);
		head.addChild(headpiece);


		slopeNew = new ModelRenderer(this);
		slopeNew.setPos(0.0F, -6.4F, 1.3F);
		headpiece.addChild(slopeNew);
		SlopeModelBox.addSlopeBox(slopeNew,
				30, 14,
				-4.0F, 0.2F, -2.8F, 0.2F,
				8.0F, 6.0F, 7.0F, 8.0F,
				0.2F, false, texWidth, texHeight);

		faceRight = new ModelRenderer(this);
		faceRight.setPos(-4.2F, -6.4F, 1.3F);
		headpiece.addChild(faceRight);
		setRotationAngle(faceRight, 0.0F, 0.3023F, 0.0F);
		faceRight.texOffs(69, 21).addBox(0.2F, 0.2F, 0.2F, 4.0F, 6.0F, 1.0F, 0.2F, false);

		faceLeft = new ModelRenderer(this);
		faceLeft.setPos(4.2F, -6.4F, 1.3F);
		headpiece.addChild(faceLeft);
		setRotationAngle(faceLeft, 0.0F, -0.3023F, 0.0F);
		faceLeft.texOffs(69, 21).addBox(-4.2F, 0.2F, 0.2F, 4.0F, 6.0F, 1.0F, 0.2F, true);

		heartSmallHead = new ModelRenderer(this);
		heartSmallHead.setPos(0.0F, 0.45F, -4.0F);
		head.addChild(heartSmallHead);


		smallHeartCube4 = new ModelRenderer(this);
		smallHeartCube4.setPos(0.0F, 0.0F, 0.0F);
		heartSmallHead.addChild(smallHeartCube4);
		setRotationAngle(smallHeartCube4, 0.0F, 0.0F, -0.7854F);
		smallHeartCube4.texOffs(4, 6).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.2F, false);

		smallHeartCube5 = new ModelRenderer(this);
		smallHeartCube5.setPos(0.3F, -0.3F, 0.0F);
		heartSmallHead.addChild(smallHeartCube5);
		setRotationAngle(smallHeartCube5, 0.0F, 0.0F, -0.7854F);
		smallHeartCube5.texOffs(4, 6).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.2F, false);

		smallHeartCube6 = new ModelRenderer(this);
		smallHeartCube6.setPos(-0.3F, -0.3F, 0.0F);
		heartSmallHead.addChild(smallHeartCube6);
		setRotationAngle(smallHeartCube6, 0.0F, 0.0F, -0.7854F);
		smallHeartCube6.texOffs(4, 6).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.2F, false);

		smallHeartCube2 = new ModelRenderer(this);
		smallHeartCube2.setPos(-0.3F, -0.3F, 0.0F);
		heartSmallHead.addChild(smallHeartCube2);
		setRotationAngle(smallHeartCube2, 0.0F, 0.0F, 0.7854F);
		smallHeartCube2.texOffs(4, 6).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.2F, true);

		smallHeartCube3 = new ModelRenderer(this);
		smallHeartCube3.setPos(0.3F, -0.3F, 0.0F);
		heartSmallHead.addChild(smallHeartCube3);
		setRotationAngle(smallHeartCube3, 0.0F, 0.0F, 0.7854F);
		smallHeartCube3.texOffs(4, 6).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.2F, true);

		torso.texOffs(20, 64).addBox(-3.5F, 1.1F, -2.1F, 7.0F, 3.0F, 1.0F, 0.4F, false);
		torso.texOffs(24, 73).addBox(-2.5F, 4.0F, -2.3F, 5.0F, 6.0F, 1.0F, 0.0F, false);
		torso.texOffs(9, 80).addBox(0.7F, 1.0F, 2.1F, 2.0F, 5.0F, 2.0F, 0.35F, true);
		torso.texOffs(9, 80).addBox(-2.7F, 1.0F, 2.1F, 2.0F, 5.0F, 2.0F, 0.35F, false);

		torso_r1 = new ModelRenderer(this);
		torso_r1.setPos(0.0F, 21.8F, 0.0F);
		torso.addChild(torso_r1);
		setRotationAngle(torso_r1, 0.0F, 0.0F, -0.7854F);
		torso_r1.texOffs(26, 81).addBox(9.7F, -6.55F, 1.15F, 1.0F, 1.0F, 1.0F, 0.125F, false);
		torso_r1.texOffs(26, 81).addBox(9.7F, -6.55F, -2.15F, 1.0F, 1.0F, 1.0F, 0.125F, false);

		torso_r2 = new ModelRenderer(this);
		torso_r2.setPos(0.0F, 21.8F, 0.0F);
		torso.addChild(torso_r2);
		setRotationAngle(torso_r2, 0.0F, 0.0F, 0.7854F);
		torso_r2.texOffs(26, 81).addBox(-10.7F, -6.55F, 1.15F, 1.0F, 1.0F, 1.0F, 0.125F, true);
		torso_r2.texOffs(26, 81).addBox(-10.7F, -6.55F, -2.15F, 1.0F, 1.0F, 1.0F, 0.125F, true);

		torso_r3 = new ModelRenderer(this);
		torso_r3.setPos(0.0F, 24.0F, 0.0F);
		torso.addChild(torso_r3);
		setRotationAngle(torso_r3, 0.0087F, -0.0008F, 0.0873F);
		torso_r3.texOffs(49, 65).addBox(0.75F, -24.4F, -2.5F, 2.0F, 10.0F, 5.0F, 0.0F, true);

		torso_r4 = new ModelRenderer(this);
		torso_r4.setPos(0.0F, 24.0F, 0.0F);
		torso.addChild(torso_r4);
		setRotationAngle(torso_r4, 0.0087F, 0.0008F, -0.0873F);
		torso_r4.texOffs(49, 65).addBox(-2.75F, -24.4F, -2.5F, 2.0F, 10.0F, 5.0F, 0.0F, false);

		tube1 = new ModelRenderer(this);
		tube1.setPos(1.0F, 2.25F, 2.25F);
		torso.addChild(tube1);
		setRotationAngle(tube1, -0.1484F, 0.2356F, 0.6196F);
		tube1.texOffs(9, 16).addBox(-0.2666F, -5.3563F, -1.4617F, 1.0F, 6.0F, 3.0F, 0.0F, true);
		tube1.texOffs(9, 25).addBox(-0.2666F, -4.3563F, -1.4617F, 1.0F, 4.0F, 2.0F, 0.0F, true);
		tube1.texOffs(9, 31).addBox(-0.2666F, -4.3563F, -0.4617F, 1.0F, 3.0F, 0.0F, 0.0F, true);

		tube2 = new ModelRenderer(this);
		tube2.setPos(-1.0F, 2.25F, 2.25F);
		torso.addChild(tube2);
		setRotationAngle(tube2, -0.1484F, -0.2356F, -0.6196F);
		tube2.texOffs(9, 16).addBox(-0.7334F, -5.3563F, -1.4617F, 1.0F, 6.0F, 3.0F, 0.0F, false);
		tube2.texOffs(9, 25).addBox(-0.7334F, -4.3563F, -1.4617F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		tube2.texOffs(9, 31).addBox(-0.7334F, -4.3563F, -0.4617F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		heartLargeAbdomen = new ModelRenderer(this);
		heartLargeAbdomen.setPos(0.0F, 9.3F, -2.0F);
		torso.addChild(heartLargeAbdomen);


		largeHeartCube3 = new ModelRenderer(this);
		largeHeartCube3.setPos(0.0F, 2.0F, 0.25F);
		heartLargeAbdomen.addChild(largeHeartCube3);
		setRotationAngle(largeHeartCube3, 0.0F, 0.0F, 0.7854F);
		largeHeartCube3.texOffs(22, 81).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 2.0F, 0.0F, 0.25F, false);
		largeHeartCube3.texOffs(19, 81).addBox(0.2F, 0.2F, -0.4F, 1.0F, 1.0F, 0.0F, 0.125F, false);

		largeHeartCube2 = new ModelRenderer(this);
		largeHeartCube2.setPos(0.0F, 2.0F, 0.25F);
		heartLargeAbdomen.addChild(largeHeartCube2);
		setRotationAngle(largeHeartCube2, 0.0F, 0.0F, -0.7854F);
		largeHeartCube2.texOffs(22, 81).addBox(0.0F, -2.0F, -0.5F, 1.0F, 2.0F, 0.0F, 0.25F, true);

		leftArm.texOffs(48, 113).addBox(1.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, -0.2F, false);

		heartLeftArm = new ModelRenderer(this);
		heartLeftArm.setPos(0.0F, 3.8F, 1.8F);
		leftArm.addChild(heartLeftArm);


		heartCube4 = new ModelRenderer(this);
		heartCube4.setPos(0.0F, 0.0F, 0.0F);
		heartLeftArm.addChild(heartCube4);
		setRotationAngle(heartCube4, 0.0F, 0.0F, -0.7854F);
		heartCube4.texOffs(48, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, false);

		heartCube5 = new ModelRenderer(this);
		heartCube5.setPos(0.5F, -0.5F, 0.0F);
		heartLeftArm.addChild(heartCube5);
		setRotationAngle(heartCube5, 0.0F, 0.0F, -0.7854F);
		heartCube5.texOffs(48, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, false);

		heartCube6 = new ModelRenderer(this);
		heartCube6.setPos(-0.5F, -0.5F, 0.0F);
		heartLeftArm.addChild(heartCube6);
		setRotationAngle(heartCube6, 0.0F, 0.0F, -0.7854F);
		heartCube6.texOffs(48, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, false);

		heartCube9 = new ModelRenderer(this);
		heartCube9.setPos(0.0F, 0.0F, 0.0F);
		heartLeftArm.addChild(heartCube9);
		setRotationAngle(heartCube9, 0.0F, 0.0F, 0.7854F);
		heartCube9.texOffs(16, 121).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, true);

		heartCube10 = new ModelRenderer(this);
		heartCube10.setPos(-0.5F, -0.5F, 0.0F);
		heartLeftArm.addChild(heartCube10);
		setRotationAngle(heartCube10, 0.0F, 0.0F, 0.7854F);
		heartCube10.texOffs(16, 121).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, true);

		leftForeArm.texOffs(32, 96).addBox(0.9F, 2.7F, -1.5F, 2.0F, 3.0F, 3.0F, -0.6F, false);
		leftForeArm.texOffs(42, 97).addBox(1.5F, 5.1F, -2.0F, 1.0F, 1.0F, 4.0F, -0.2F, false);

		leftForeArm_r1 = new ModelRenderer(this);
		leftForeArm_r1.setPos(-5.4F, 18.3F, 0.0F);
		leftForeArm.addChild(leftForeArm_r1);
		setRotationAngle(leftForeArm_r1, 0.0F, 0.0F, 0.0436F);
		leftForeArm_r1.texOffs(16, 119).addBox(2.7F, -19.2F, -2.0F, 4.0F, 4.0F, 4.0F, 0.2F, true);

		leftForeArm_r2 = new ModelRenderer(this);
		leftForeArm_r2.setPos(-5.5455F, 18.1936F, 3.15F);
		leftForeArm.addChild(leftForeArm_r2);
		setRotationAngle(leftForeArm_r2, 0.0F, 0.0F, 0.0436F);
		leftForeArm_r2.texOffs(24, 117).addBox(2.7F, -14.85F, -2.0F, 1.0F, 1.0F, 1.0F, 0.05F, true);
		leftForeArm_r2.texOffs(24, 117).addBox(2.7F, -14.85F, -4.2F, 1.0F, 1.0F, 1.0F, 0.05F, true);

		leftForeArm_r3 = new ModelRenderer(this);
		leftForeArm_r3.setPos(-5.4456F, 18.1979F, -0.15F);
		leftForeArm.addChild(leftForeArm_r3);
		setRotationAngle(leftForeArm_r3, 0.0F, 0.0F, 0.0436F);
		leftForeArm_r3.texOffs(24, 117).addBox(3.7F, -14.85F, -2.0F, 1.0F, 1.0F, 1.0F, 0.05F, true);

		leftForeArm_r4 = new ModelRenderer(this);
		leftForeArm_r4.setPos(-7.3438F, 18.115F, -0.15F);
		leftForeArm.addChild(leftForeArm_r4);
		setRotationAngle(leftForeArm_r4, 0.0F, 0.0F, 0.0436F);
		leftForeArm_r4.texOffs(24, 117).addBox(7.8F, -14.85F, -2.0F, 1.0F, 1.0F, 1.0F, 0.05F, true);
		leftForeArm_r4.texOffs(24, 117).addBox(7.8F, -14.85F, 0.2F, 1.0F, 1.0F, 1.0F, 0.05F, true);

		leftForeArm_r5 = new ModelRenderer(this);
		leftForeArm_r5.setPos(-7.4437F, 18.1107F, 3.15F);
		leftForeArm.addChild(leftForeArm_r5);
		setRotationAngle(leftForeArm_r5, 0.0F, 0.0F, 0.0436F);
		leftForeArm_r5.texOffs(24, 117).addBox(6.8F, -14.85F, -2.0F, 1.0F, 1.0F, 1.0F, 0.05F, true);

		rightArm.texOffs(48, 113).addBox(-2.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, -0.2F, true);

		heartRightArm = new ModelRenderer(this);
		heartRightArm.setPos(0.0F, 3.8F, 1.8F);
		rightArm.addChild(heartRightArm);


		heartCube1 = new ModelRenderer(this);
		heartCube1.setPos(0.0F, 0.0F, 0.0F);
		heartRightArm.addChild(heartCube1);
		setRotationAngle(heartCube1, 0.0F, 0.0F, -0.7854F);
		heartCube1.texOffs(16, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, false);

		heartCube2 = new ModelRenderer(this);
		heartCube2.setPos(0.5F, -0.5F, 0.0F);
		heartRightArm.addChild(heartCube2);
		setRotationAngle(heartCube2, 0.0F, 0.0F, -0.7854F);
		heartCube2.texOffs(16, 121).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, false);

		heartCube3 = new ModelRenderer(this);
		heartCube3.setPos(0.5F, -0.5F, 0.0F);
		heartRightArm.addChild(heartCube3);
		setRotationAngle(heartCube3, 0.0F, 0.0F, 0.7854F);
		heartCube3.texOffs(48, 121).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, true);

		heartCube7 = new ModelRenderer(this);
		heartCube7.setPos(0.0F, 0.0F, 0.0F);
		heartRightArm.addChild(heartCube7);
		setRotationAngle(heartCube7, 0.0F, 0.0F, 0.7854F);
		heartCube7.texOffs(48, 121).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, true);

		heartCube8 = new ModelRenderer(this);
		heartCube8.setPos(-0.5F, -0.5F, 0.0F);
		heartRightArm.addChild(heartCube8);
		setRotationAngle(heartCube8, 0.0F, 0.0F, 0.7854F);
		heartCube8.texOffs(48, 121).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, true);

		rightForeArm.texOffs(32, 96).addBox(-2.9F, 2.7F, -1.5F, 2.0F, 3.0F, 3.0F, -0.6F, true);
		rightForeArm.texOffs(42, 97).addBox(-2.5F, 5.1F, -2.0F, 1.0F, 1.0F, 4.0F, -0.2F, true);

		rightForeArm_r1 = new ModelRenderer(this);
		rightForeArm_r1.setPos(5.5455F, 18.1936F, 3.15F);
		rightForeArm.addChild(rightForeArm_r1);
		setRotationAngle(rightForeArm_r1, 0.0F, 0.0F, -0.0436F);
		rightForeArm_r1.texOffs(24, 117).addBox(-3.7F, -14.85F, -4.2F, 1.0F, 1.0F, 1.0F, 0.05F, false);
		rightForeArm_r1.texOffs(24, 117).addBox(-3.7F, -14.85F, -2.0F, 1.0F, 1.0F, 1.0F, 0.05F, false);

		rightForeArm_r2 = new ModelRenderer(this);
		rightForeArm_r2.setPos(5.4F, 18.3F, 0.0F);
		rightForeArm.addChild(rightForeArm_r2);
		setRotationAngle(rightForeArm_r2, 0.0F, 0.0F, -0.0436F);
		rightForeArm_r2.texOffs(16, 119).addBox(-6.7F, -19.2F, -2.0F, 4.0F, 4.0F, 4.0F, 0.2F, false);

		rightForeArm_r3 = new ModelRenderer(this);
		rightForeArm_r3.setPos(5.4456F, 18.1979F, -0.15F);
		rightForeArm.addChild(rightForeArm_r3);
		setRotationAngle(rightForeArm_r3, 0.0F, 0.0F, -0.0436F);
		rightForeArm_r3.texOffs(24, 117).addBox(-4.7F, -14.85F, -2.0F, 1.0F, 1.0F, 1.0F, 0.05F, false);

		rightForeArm_r4 = new ModelRenderer(this);
		rightForeArm_r4.setPos(7.3438F, 18.115F, -0.15F);
		rightForeArm.addChild(rightForeArm_r4);
		setRotationAngle(rightForeArm_r4, 0.0F, 0.0F, -0.0436F);
		rightForeArm_r4.texOffs(24, 117).addBox(-8.8F, -14.85F, -2.0F, 1.0F, 1.0F, 1.0F, 0.05F, false);
		rightForeArm_r4.texOffs(24, 117).addBox(-8.8F, -14.85F, 0.2F, 1.0F, 1.0F, 1.0F, 0.05F, false);

		rightForeArm_r5 = new ModelRenderer(this);
		rightForeArm_r5.setPos(7.4437F, 18.1107F, 3.15F);
		rightForeArm.addChild(rightForeArm_r5);
		setRotationAngle(rightForeArm_r5, 0.0F, 0.0F, -0.0436F);
		rightForeArm_r5.texOffs(24, 117).addBox(-7.8F, -14.85F, -2.0F, 1.0F, 1.0F, 1.0F, 0.05F, false);

		leftLeg.texOffs(112, 108).addBox(1.8F, -1.25F, -1.5F, 1.0F, 3.0F, 3.0F, 0.1F, false);

		heartLeftLeg = new ModelRenderer(this);
		heartLeftLeg.setPos(0.075F, 5.0F, -1.9F);
		leftLeg.addChild(heartLeftLeg);
		setRotationAngle(heartLeftLeg, 0.0F, 0.0F, 0.0873F);
		heartLeftLeg.texOffs(121, 107).addBox(0.0875F, -1.0F, -0.6F, 1.0F, 2.0F, 1.0F, -0.15F, true);
		heartLeftLeg.texOffs(120, 110).addBox(-1.2375F, -1.5F, -0.7F, 2.0F, 3.0F, 1.0F, -0.25F, false);

		leftLowerLeg.texOffs(80, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.2F, true);

		rightLeg.texOffs(112, 108).addBox(-2.8F, -1.25F, -1.5F, 1.0F, 3.0F, 3.0F, 0.1F, true);

		heartRightLeg = new ModelRenderer(this);
		heartRightLeg.setPos(0.175F, 5.0F, -1.9F);
		rightLeg.addChild(heartRightLeg);
		setRotationAngle(heartRightLeg, 0.0F, 0.0F, -0.0873F);
		heartRightLeg.texOffs(121, 107).addBox(-1.3375F, -1.0F, -0.6F, 1.0F, 2.0F, 1.0F, -0.15F, false);
		heartRightLeg.texOffs(120, 110).addBox(-1.0125F, -1.5F, -0.7F, 2.0F, 3.0F, 1.0F, -0.25F, true);

		rightLowerLeg.texOffs(80, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.2F, false);
	}

	@Override
	protected RotationAngle[][] initSummonPoseRotations() {
		return new RotationAngle[][]{
				new RotationAngle[]{
						RotationAngle.fromDegrees(head, -23.94412f, -5.79396f, 11.45258f),
						RotationAngle.fromDegrees(body, -7.5f, -50f, 0),
						RotationAngle.fromDegrees(upperPart, 0, 0, 0),
						RotationAngle.fromDegrees(leftArm, 5.24264f, 17.64914f, -0.916f),
						RotationAngle.fromDegrees(leftForeArm, -67.5f, 0, 0),
						RotationAngle.fromDegrees(rightArm, -23.94412f, -5.79396f, 11.45258f),
						RotationAngle.fromDegrees(rightForeArm, -12.5F, 0, 2.5F),
						RotationAngle.fromDegrees(leftLeg, -45F, 0, -5F),
						RotationAngle.fromDegrees(leftLowerLeg, 52.5F, 0, 0),
						RotationAngle.fromDegrees(rightLeg, 20f, 5f, 0),
						RotationAngle.fromDegrees(rightLowerLeg, 22.5F, 0, 0)
				},
				new RotationAngle[]{
						RotationAngle.fromDegrees(head, 12.5f, 0, 0),
						RotationAngle.fromDegrees(body, 0, 32.5F, 0),
						RotationAngle.fromDegrees(upperPart, 0, 0, 0),
						RotationAngle.fromDegrees(leftArm, 31.06171f, 14.67052f, -38.7015f),
						RotationAngle.fromDegrees(leftForeArm, -54.5052f, 12.83214f, 11.02332f),
						RotationAngle.fromDegrees(rightArm, -22.5947f, -25.61033F, 74.7314F),
						RotationAngle.fromDegrees(rightForeArm, -49.18983f, -2.16323f, -15.18379f),
						RotationAngle.fromDegrees(leftLeg, 0, 0, -10f),
						RotationAngle.fromDegrees(leftLowerLeg, 52.5F, 0, 0),
						RotationAngle.fromDegrees(rightLeg, -25f, 0, 10f),
						RotationAngle.fromDegrees(rightLowerLeg, 60F, 0, 0)
				},
				new RotationAngle[]{
						RotationAngle.fromDegrees(head, 12.5f, 0, 0),
						RotationAngle.fromDegrees(body, -10, 32.5f, 0),
						RotationAngle.fromDegrees(upperPart, 0, 0, 0),
						RotationAngle.fromDegrees(leftArm, -171.9292f, -55.8606f,17.249f),
						RotationAngle.fromDegrees(leftForeArm, -97.71917f, 3.8993f, 23.21666f),
						RotationAngle.fromDegrees(rightArm, -153.63437f, 54.47308f, -19.57356F),
						RotationAngle.fromDegrees(rightForeArm, -106.68983f, -2.16323f, -15.18379f),
						RotationAngle.fromDegrees(leftLeg, 0, 0, -10f),
						RotationAngle.fromDegrees(leftLowerLeg, 52.5F, 0, 0),
						RotationAngle.fromDegrees(rightLeg, -25f, 0, 10f),
						RotationAngle.fromDegrees(rightLowerLeg, 60F, 0, 0)
				}

		};
	}

	@Override
	protected void initActionPoses() {
		ModelPose<THEWORLDEntity> heavyPunchPose1 = new ModelPose<>(new RotationAngle[] {

				RotationAngle.fromDegrees(body, 12.5F, 0F, 0F),
				RotationAngle.fromDegrees(leftArm, 48.4155F, -50.01155F, -69.17924F),
				RotationAngle.fromDegrees(leftForeArm, -27.01413F, 29.11999F, 21.62725F),
				RotationAngle.fromDegrees(rightArm, 12.5F, 50F, 80F),
				RotationAngle.fromDegrees(rightForeArm, -65F, -22.5F, -90F),
				RotationAngle.fromDegrees(leftLeg, 0F, 2.5F, -7.5F),
				RotationAngle.fromDegrees(leftLowerLeg, 32.5F, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, -27.5F, 15F, 7.5F),
				RotationAngle.fromDegrees(rightLowerLeg, 72.5F, 0F, 0F)
		});
		ModelPose<THEWORLDEntity> heavyPunchPose2 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, -12.5F, 0F, 0F),
				RotationAngle.fromDegrees(body, 26.78135F, 20.29348F, 9.92926F),
				RotationAngle.fromDegrees(leftArm, 46.6566F, -65.16127F, -103.5066F),
				RotationAngle.fromDegrees(leftForeArm, -48.19025F, 28.00516F, 94.57968F),
				RotationAngle.fromDegrees(rightArm, 44.36766F, 50.99246F, 101.9388F),
				RotationAngle.fromDegrees(rightForeArm, -45F, -15, -90F),
				RotationAngle.fromDegrees(leftLeg, 10F, 0F, 0F),
				RotationAngle.fromDegrees(leftLowerLeg, 32.5F, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, -27.5F, 15F, 7.5F),
				RotationAngle.fromDegrees(rightLowerLeg, 72.5F, 0F, 0F)
		});
		ModelPose<THEWORLDEntity> heavyPunchPose3 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, 15.69284F, 16.88547F, 4.6653F),
				RotationAngle.fromDegrees(body,15.46025F, -46.10107F, -12.98921F),
				RotationAngle.fromDegrees(leftArm, 45.2214F, -34.59909F, -58.45635F),
				RotationAngle.fromDegrees(leftForeArm, -28.10276F, -0.43851F, 74.07713F),
				RotationAngle.fromDegrees(rightArm, -68.32273F, 6.0881F, 49.92082F),
				RotationAngle.fromDegrees(rightForeArm, -54.27642F, 17.45461F, -58.39005F),
				RotationAngle.fromDegrees(leftLeg, -60F, 0F, 0F),
				RotationAngle.fromDegrees(leftLowerLeg, 105F, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, 15F, 15F, 7.5F),
				RotationAngle.fromDegrees(rightLowerLeg, 17.5F, 0F, 0F)
		});
		ModelPose<THEWORLDEntity> heavyPunchPose4 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, 15.69284F, 16.88547F, 4.6653F),
				RotationAngle.fromDegrees(body, 15.46025F, -46.10107F, -12.98921F),
				RotationAngle.fromDegrees(leftArm, 45.2214F, -34.59909F, -58.45635F),
				RotationAngle.fromDegrees(leftForeArm, -28.10276F, -0.43851F, 74.07713F),
				RotationAngle.fromDegrees(rightArm, -68.32273F, 6.0881F, 49.92082F),
				RotationAngle.fromDegrees(rightForeArm, -54.27642F, 17.45461F, -58.39005F),
				RotationAngle.fromDegrees(leftLeg, -60F, 0.0F, 0F),
				RotationAngle.fromDegrees(leftLowerLeg, 105, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, 15F, 15F, 7.5F),
				RotationAngle.fromDegrees(rightLowerLeg, 17.5F, 0F, 0F)
		});
		actionAnim.put(StandPose.HEAVY_ATTACK, new PosedActionAnimation.Builder<THEWORLDEntity>()
				.addPose(StandEntityAction.Phase.WINDUP, new ModelPoseTransition<>(heavyPunchPose1, heavyPunchPose2).setEasing(pr -> Math.max(pr * 3F - 2F, 0F)))
				.addPose(StandEntityAction.Phase.PERFORM, new ModelPoseTransition<>(heavyPunchPose2, heavyPunchPose3))
				.addPose(StandEntityAction.Phase.RECOVERY, new ModelPoseTransitionMultiple.Builder<>(heavyPunchPose3)
						.addPose(0.5F, heavyPunchPose3)
						.addPose(0.7F, heavyPunchPose4)
						.addPose(0.8F, heavyPunchPose4)
						.build(idlePose))
				.build(idlePose));

		ModelPose<THEWORLDEntity> knockbackPunchPose1 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, 0F,  0F, 0F),
				RotationAngle.fromDegrees(body, 32.5F, -30F, 0F),
				RotationAngle.fromDegrees(upperPart, 0F, 0F, 0F),
				RotationAngle.fromDegrees(leftArm, 4.83045F, -1.29256F, -30.05452F),
				RotationAngle.fromDegrees(leftForeArm, -75.60655F, 0.93164F, 2.461F),
				RotationAngle.fromDegrees(rightArm, -22.5F, 30, 15F),
				RotationAngle.fromDegrees(rightForeArm, -90F, 60, -90F),
				RotationAngle.fromDegrees(leftLeg, 5F, 10F, -15F),
				RotationAngle.fromDegrees(leftLowerLeg, 25F, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, -99.38095F, 6.58454F, 4.58398F),
				RotationAngle.fromDegrees(rightLowerLeg, 102.21636F, 5.74146F, -3.32735F)
		});
		ModelPose<THEWORLDEntity> knockbackPunchPose2 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, 0F,  0F, 0F),
				RotationAngle.fromDegrees(body, 32.5F, -30F, 0F),
				RotationAngle.fromDegrees(upperPart, 0F, 15F, 0F),
				RotationAngle.fromDegrees(leftArm, -6.78112F, -5.71617F, -25.41103F),
				RotationAngle.fromDegrees(leftForeArm, -80F, 0F, 0F),
				RotationAngle.fromDegrees(rightArm, 44.00703F, -10.54529F, 25.72858F),
				RotationAngle.fromDegrees(rightForeArm, -90F, -30F, -90F),
				RotationAngle.fromDegrees(leftLeg,4.10275F, 10.39703F, -20.06429F),
				RotationAngle.fromDegrees(rightLeg, -99.85531F, 18.9103F, 2.44682F),
		});
		ModelPose<THEWORLDEntity> knockbackPunchPose3 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, -12.5F, 0F, 0F),
				RotationAngle.fromDegrees(body, 0F, -30F, 0F),
				RotationAngle.fromDegrees(upperPart, 0F, -45F, 0F),
				RotationAngle.fromDegrees(leftArm, 41.74166F, -16.64166F, -35.06714F),
				RotationAngle.fromDegrees(leftForeArm, -88.9429F, -2.26564F, 64.9791F),
				RotationAngle.fromDegrees(rightArm, -81.98507F, 55.18322F, 41.78392F),
				RotationAngle.fromDegrees(rightForeArm, -90F, 60F, -90F),
				RotationAngle.fromDegrees(leftLeg, 5.42832F, -24.86419F, -18.15846F),
				RotationAngle.fromDegrees(rightLeg, -75.5065F, 0.95968F, 46.47268F),
				RotationAngle.fromDegrees(rightLowerLeg, 102.21636F, 5.74146F, -3.32735F)
		});
		actionAnim.put(StandPose.HEAVY_ATTACK_FINISHER, new PosedActionAnimation.Builder<THEWORLDEntity>()
				.addPose(StandEntityAction.Phase.WINDUP, new ModelPoseTransitionMultiple.Builder<>(idlePose)
						.addPose(0.5F, knockbackPunchPose1)
						.addPose(0.75F, knockbackPunchPose2)
						.addPose(0.95F, knockbackPunchPose3)
						.build(knockbackPunchPose3))
				.build(idlePose));

		ModelPose<THEWORLDEntity> timeStopPose1 = new ModelPose<>(new RotationAngle[] {

				RotationAngle.fromDegrees(body, 12.5F, 0F, 0F),
				RotationAngle.fromDegrees(leftArm, 48.4155F, -50.01155F, -69.17924F),
				RotationAngle.fromDegrees(leftForeArm, -27.01413F, 29.11999F, 21.62725F),
				RotationAngle.fromDegrees(rightArm, 12.5F, 50F, 80F),
				RotationAngle.fromDegrees(rightForeArm, -65F, -22.5F, -90F),
				RotationAngle.fromDegrees(leftLeg, 0F, 2.5F, -7.5F),
				RotationAngle.fromDegrees(leftLowerLeg, 32.5F, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, -27.5F, 15F, 7.5F),
				RotationAngle.fromDegrees(rightLowerLeg, 72.5F, 0F, 0F)
		});
		ModelPose<THEWORLDEntity> timeStopPose2 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, -12.5F, 0F, 0F),
				RotationAngle.fromDegrees(body, 26.78135F, 20.29348F, 9.92926F),
				RotationAngle.fromDegrees(leftArm, 46.6566F, -65.16127F, -103.5066F),
				RotationAngle.fromDegrees(leftForeArm, -48.19025F, 28.00516F, 94.57968F),
				RotationAngle.fromDegrees(rightArm, 44.36766F, 50.99246F, 101.9388F),
				RotationAngle.fromDegrees(rightForeArm, -45F, -15, -90F),
				RotationAngle.fromDegrees(leftLeg, 10F, 0F, 0F),
				RotationAngle.fromDegrees(leftLowerLeg, 32.5F, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, -27.5F, 15F, 7.5F),
				RotationAngle.fromDegrees(rightLowerLeg, 72.5F, 0F, 0F)
		});
		ModelPose<THEWORLDEntity> timeStopPose3 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, 15.69284F, 16.88547F, 4.6653F),
				RotationAngle.fromDegrees(body,15.46025F, -46.10107F, -12.98921F),
				RotationAngle.fromDegrees(leftArm, 45.2214F, -34.59909F, -58.45635F),
				RotationAngle.fromDegrees(leftForeArm, -28.10276F, -0.43851F, 74.07713F),
				RotationAngle.fromDegrees(rightArm, -68.32273F, 6.0881F, 49.92082F),
				RotationAngle.fromDegrees(rightForeArm, -54.27642F, 17.45461F, -58.39005F),
				RotationAngle.fromDegrees(leftLeg, -60F, 0F, 0F),
				RotationAngle.fromDegrees(leftLowerLeg, 105F, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, 15F, 15F, 7.5F),
				RotationAngle.fromDegrees(rightLowerLeg, 17.5F, 0F, 0F)
		});
		ModelPose<THEWORLDEntity> timeStopPose4 = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(head, 15.69284F, 16.88547F, 4.6653F),
				RotationAngle.fromDegrees(body, 15.46025F, -46.10107F, -12.98921F),
				RotationAngle.fromDegrees(leftArm, 45.2214F, -34.59909F, -58.45635F),
				RotationAngle.fromDegrees(leftForeArm, -28.10276F, -0.43851F, 74.07713F),
				RotationAngle.fromDegrees(rightArm, -68.32273F, 6.0881F, 49.92082F),
				RotationAngle.fromDegrees(rightForeArm, -54.27642F, 17.45461F, -58.39005F),
				RotationAngle.fromDegrees(leftLeg, -60F, 0.0F, 0F),
				RotationAngle.fromDegrees(leftLowerLeg, 105F, 0F, 0F),
				RotationAngle.fromDegrees(rightLeg, 15F, 15F, 7.5F),
				RotationAngle.fromDegrees(rightLowerLeg, 17.5F, 0F, 0F)
		});
		actionAnim.put(THEWORLDTimeStop.TIME_STOP, new PosedActionAnimation.Builder<THEWORLDEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
						.addPose(0.5F, timeStopPose1)
						.addPose(0.75F, timeStopPose2)
						.addPose(0.75F, timeStopPose3)
						.addPose(0.95F, timeStopPose4)
						.build(timeStopPose4))
				.build(idlePose));

		super.initActionPoses();
	}

	@Override
	protected ModelPose<THEWORLDEntity> initIdlePose() {
		return new ModelPose<>(new RotationAngle[] {
				 RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
				 RotationAngle.fromDegrees(body, -8.7F, 50F, -2F),
				 RotationAngle.fromDegrees(leftArm, 0.0F, 5F, -20F),
				 RotationAngle.fromDegrees(leftForeArm, -25F, 0.0F, 0.0F),
				 RotationAngle.fromDegrees(rightArm, 20.2F, 1F, 10F),
				 RotationAngle.fromDegrees(rightForeArm, -30F, 0.0F, 0.0F),
				 RotationAngle.fromDegrees(leftLeg, 2.5F, -17.5F, -5.2F),
				 RotationAngle.fromDegrees(leftLowerLeg, 22.5F, 0.0F, 0.0F),
				 RotationAngle.fromDegrees(rightLeg, -26F, 31.0F, 7.5F),
				 RotationAngle.fromDegrees(rightLowerLeg, 92.5F, 0.0F, 0.0F)
		});
	}

	@Override
	protected ModelPose<THEWORLDEntity> initIdlePose2Loop() {
		return new ModelPose<>(new RotationAngle[] {
				 RotationAngle.fromDegrees(leftArm, 5F, 5F, -20F),
				 RotationAngle.fromDegrees(leftForeArm, -32.5F, 0.0F, 0F),
				 RotationAngle.fromDegrees(rightArm, 25F, 1F, 10F),
				 RotationAngle.fromDegrees(rightForeArm, -32.5F, 0.0F, 0.0F),
				 RotationAngle.fromDegrees(leftLeg, 8F, -17.5F, -5.2F),
				 RotationAngle.fromDegrees(leftLowerLeg, 25F, 0.0F, 0.0F),
				 RotationAngle.fromDegrees(rightLeg, -28.5F, 31.0F, 8.5F),
				 RotationAngle.fromDegrees(rightLowerLeg, 100F, 0.0F, 0.0F)
		});
	}
}