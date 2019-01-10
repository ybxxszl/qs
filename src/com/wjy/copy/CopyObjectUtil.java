package com.wjy.copy;

import org.springframework.cglib.beans.BeanCopier;

public class CopyObjectUtil {

	public static void copyObjectByApache(Object dest, Object orig) {

		try {

			org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void copyObjectBySpring(Object source, Object target) {

		try {

			org.springframework.beans.BeanUtils.copyProperties(source, target);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {

		CopyBean sourceCopyBean = new CopyBean();

		sourceCopyBean.setId("007");
		sourceCopyBean.setName("詹姆斯·邦德");

		CopyBean targetCopyBean = new CopyBean();

		BeanCopier beanCopier = BeanCopier.create(sourceCopyBean.getClass(), targetCopyBean.getClass(), false);
		beanCopier.copy(sourceCopyBean, targetCopyBean, null);

		System.out.println("sourceCopyBean: " + sourceCopyBean.toString());
		System.out.println("targetCopyBean: " + targetCopyBean.toString());

		sourceCopyBean.setId("sourceCopyBean - " + sourceCopyBean.getId());
		targetCopyBean.setId("targetCopyBean - " + targetCopyBean.getId());

		System.out.println("sourceCopyBean: " + sourceCopyBean.toString());
		System.out.println("targetCopyBean: " + targetCopyBean.toString());

	}

}
