package net.wicp.tams.app.duckula.controller.service.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import net.wicp.tams.app.duckula.controller.bean.models.SysPermissions;
import net.wicp.tams.app.duckula.controller.bean.models.SysRole;
import net.wicp.tams.app.duckula.controller.bean.models.SysUser;
import net.wicp.tams.app.duckula.controller.service.LoginService;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private LoginService loginService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 获取登录用户名
		String name = (String) principalCollection.getPrimaryPrincipal();
		// 查询用户名称
		SysUser user = loginService.getUserByName(name);
		// 添加角色和权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (SysRole role : user.getRoleList()) {
			// 添加角色
			simpleAuthorizationInfo.addRole(role.getName());
			// 添加权限
			for (SysPermissions permissions : role.getSysPermissionsList()) {
				simpleAuthorizationInfo.addStringPermission(permissions.getName());
			}
		}
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		// 获取用户信息
		String name = authenticationToken.getPrincipal().toString();
		SysUser user = loginService.getUserByName(name);
		if (user == null) {
			// 这里返回后会报出对应异常
			return null;
		} else {
			// 这里验证authenticationToken和simpleAuthenticationInfo的信息
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name,
					user.getPassword().toString(), getName());
			
			SecurityUtils.getSubject().getSession().setAttribute(ShiroAssit.UserAttribute, user);
			return simpleAuthenticationInfo;
		}
	}
}
