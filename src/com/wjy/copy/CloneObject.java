package com.wjy.copy;

/**
 * 克隆对象
 * 
 * @author wjy
 * @date 2019年1月10日
 */
public class CloneObject {

	/**
	 * 使用Apache的BeanUtils克隆对象
	 * 
	 * @param source
	 * @param target
	 */
	public static void cloneObject1(Object source, Object target) {

		try {

			org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * 使用Spring的BeanUtils克隆对象
	 * 
	 * @param source
	 * @param target
	 */
	public static void cloneObject2(Object source, Object target) {

		try {

			org.springframework.beans.BeanUtils.copyProperties(source, target);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * 使用Spring的BeanCopier克隆对象
	 * 
	 * @param source
	 * @param target
	 */
	public static void cloneObject3(Object source, Object target) {

		org.springframework.cglib.beans.BeanCopier beanCopier = org.springframework.cglib.beans.BeanCopier
				.create(source.getClass(), target.getClass(), false);
		beanCopier.copy(source, target, null);

	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		CloneBean sourceCloneBean = new CloneBean();

		sourceCloneBean.setId("007");
		sourceCloneBean.setName("詹姆斯·邦德");

		CloneBean targetCloneBean = new CloneBean();

		cloneObject3(sourceCloneBean, targetCloneBean);

		System.out.println("sourceCopyBean: " + sourceCloneBean.toString());
		System.out.println("targetCopyBean: " + targetCloneBean.toString());

		sourceCloneBean.setId("sourceCopyBean - " + sourceCloneBean.getId());
		targetCloneBean.setId("targetCopyBean - " + targetCloneBean.getId());

		System.out.println("sourceCopyBean: " + sourceCloneBean.toString());
		System.out.println("targetCopyBean: " + targetCloneBean.toString());

	}

}
