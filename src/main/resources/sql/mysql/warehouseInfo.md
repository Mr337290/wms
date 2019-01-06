sample
===
* 注释

	select #use("cols")# from warehouse_info  where  #use("condition")#

cols
===
	id,sn,batch_number,quantity,price,currency,inventory,create_time,modify_time

updateSample
===
	
	id=#id#,sn=#sn#,batch_number=#batchNumber#,quantity=#quantity#,price=#price#,currency=#currency#,inventory=#inventory#,create_time=#createTime#,modify_time=#modifyTime#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
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
	@if(!isEmpty(inventory)){
	 and inventory=#inventory#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	@if(!isEmpty(modifyTime)){
	 and modify_time=#modifyTime#
	@}
	
	