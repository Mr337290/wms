sample
===
* 注释

	select #use("cols")# from vw_sell_details_for_day  where  #use("condition")#

cols
===
	sell_date,shop_code,sn,batch_number,quantitys,amount,currency

updateSample
===
	
	sell_date=#sellDate#,shop_code=#shopCode#,sn=#sn#,batch_number=#batchNumber#,quantitys=#quantitys#,amount=#amount#,currency=#currency#

condition
===

	1 = 1  
	@if(!isEmpty(sellDate)){
	 and sell_date=#sellDate#
	@}
	@if(!isEmpty(shopCode)){
	 and shop_code=#shopCode#
	@}
	@if(!isEmpty(sn)){
	 and sn=#sn#
	@}
	@if(!isEmpty(batchNumber)){
	 and batch_number=#batchNumber#
	@}
	@if(!isEmpty(quantitys)){
	 and quantitys=#quantitys#
	@}
	@if(!isEmpty(amount)){
	 and amount=#amount#
	@}
	@if(!isEmpty(currency)){
	 and currency=#currency#
	@}
	
	