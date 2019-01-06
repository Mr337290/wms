sample
===
* 注释

	select #use("cols")# from shop_info  where  #use("condition")#

cols
===
	id,name,code,managers,phone,mail,address,status

updateSample
===
	
	id=#id#,name=#name#,code=#code#,managers=#managers#,phone=#phone#,mail=#mail#,address=#address#,status=#status#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(code)){
	 and code=#code#
	@}
	@if(!isEmpty(managers)){
	 and managers=#managers#
	@}
	@if(!isEmpty(phone)){
	 and phone=#phone#
	@}
	@if(!isEmpty(mail)){
	 and mail=#mail#
	@}
	@if(!isEmpty(address)){
	 and address=#address#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
	@}
	
	