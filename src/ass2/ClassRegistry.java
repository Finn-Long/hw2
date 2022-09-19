package ass2;

import ass2.Factory.ControllerFactory;
import ass2.Factory.ModelFactory;
import ass2.Factory.SocialDistanceClassifierFactory;
import ass2.Factory.ViewFactory;
import ass2.Models.BasicModel;
import ass2.Models.DerivingModel;
import ass2.Models.InterpolatingModel;
import ass2.View.SocialDistanceView;
import ass2.Weka.InferringMain;
import ass2.Weka.InferringModel;

public class ClassRegistry implements gradingTools.comp524f22.assignment2.F22A2SocialDistanceClassRegistry{

	@Override
	public Class<?> getBasicSocialDistanceUtility() {
		return BasicSocialDistanceUtility.class;
	}

	@Override
	public Class<?> getSocialDistancDerivingModel() {
		return DerivingModel.class;
	}

	@Override
	public Class<?> getSocialDistancInferringModel() {
		// TODO Auto-generated method stub
		return InferringModel.class;
	}

	@Override
	public Class<?> getSocialDistanceBasicModel() {
		return BasicModel.class;
	}

	@Override
	public Class<?> getSocialDistanceClassifierFactory() {
		return SocialDistanceClassifierFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceController() {
		return SocialDistanceController.class;
	}

	@Override
	public Class<?> getSocialDistanceControllerFactory() {
		return ControllerFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceInterpolatingModel() {
		return InterpolatingModel.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCBasicMain() {
		return BasicMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCDerivingMain() {
		return DerivingMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCInferringMain() {
		// TODO Auto-generated method stub
		return InferringMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCInterpolatingMain() {
		return InterpolatingMain.class;
	}

	@Override
	public Class<?> getSocialDistanceModelFactory() {
		return ModelFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceUilityTesterMain() {
		return SocialDistanceUtilityTesterMain.class;
	}

	@Override
	public Class<?> getSocialDistanceView() {
		return SocialDistanceView.class;
	}

	@Override
	public Class<?> getSocialDistanceViewFactory() {
		return ViewFactory.class;
	}

}
