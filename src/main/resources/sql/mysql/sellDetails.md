sample
===
* 注释

	select #use("cols")# from sell_details  where  #use("condition")#

cols
===
	id,sell_time,sn,batch_number,quantity,price,currency,shop_code,create_time

updateSample
===
	
	id=#id#,sell_time=#sellTime#,sn=#sn#,batch_number=#batchNumber#,quantity=#quantity#,price=#price#,currency=#currency#,shop_code=#shopCode#,create_time=#createTime#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(sellTime)){
	 and sell_time=#sellTime#
	@}
	@if(!isEmpty(sn)){
	 and sn=#sn#
	@}
	@if(!isEmpty(batchNumber)){
	 and batch_number=#batchNumber#
	@}
	@if(!isEmpty(quantity)){
	 and quantity=#quantity#
	@}
	@if(!isEmpty(price)){
	 and price=#price#
	@}
	@if(!isEmpty(currency)){
	 and currency=#currency#
	@}
	@if(!isEmpty(shopCode)){
	 and shop_code=#shopCode#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	
	