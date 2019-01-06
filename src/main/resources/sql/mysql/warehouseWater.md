sample
===
* 注释

	select #use("cols")# from warehouse_water  where  #use("condition")#

cols
===
	id,warehouse_id,quantity,status,operator,operand,create_time

updateSample
===
	
	id=#id#,warehouse_id=#warehouseId#,quantity=#quantity#,status=#status#,operator=#operator#,operand=#operand#,create_time=#createTime#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(warehouseId)){
	 and warehouse_id=#warehouseId#
	@}
	@if(!isEmpty(quantity)){
	 and quantity=#quantity#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
	@}
	@if(!isEmpty(operator)){
	 and operator=#operator#
	@}
	@if(!isEmpty(operand)){
	 and operand=#operand#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	
	