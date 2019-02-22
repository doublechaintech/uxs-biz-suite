

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './NewProduct.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(newProduct)=>{return [
	   {"title":'Product Cover Image',"imageLocation":newProduct.productCoverImage},
]}

const internalImageListOf = (newProduct) =>defaultImageListOf(newProduct,imageList)

const optionList =(newProduct)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (newProduct) =>defaultSettingListOf(newProduct, optionList)
const internalLargeTextOf = (newProduct) =>{

	return(<div> 
   <Card title={`Remark`} ><pre>{newProduct.remark}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (newProduct,targetComponent) =>{
	
	
	const {NewProductService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{newProduct.id}</Description> 
<Description term="Name">{newProduct.name}</Description> 
<Description term="Parent Category">{newProduct.parentCategory==null?appLocaleName(userContext,"NotAssigned"):newProduct.parentCategory.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Parent Category","levelNCategory",NewProductService.requestCandidateParentCategory,
	      NewProductService.transferToAnotherParentCategory,"anotherParentCategoryId",newProduct.parentCategory?newProduct.parentCategory.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Brand">{newProduct.brand==null?appLocaleName(userContext,"NotAssigned"):newProduct.brand.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Brand","brand",NewProductService.requestCandidateBrand,
	      NewProductService.transferToAnotherBrand,"anotherBrandId",newProduct.brand?newProduct.brand.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Origin">{newProduct.origin}</Description> 
<Description term="Catalog">{newProduct.catalog==null?appLocaleName(userContext,"NotAssigned"):newProduct.catalog.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Catalog","catalog",NewProductService.requestCandidateCatalog,
	      NewProductService.transferToAnotherCatalog,"anotherCatalogId",newProduct.catalog?newProduct.catalog.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Profile">{newProduct.profile==null?appLocaleName(userContext,"NotAssigned"):newProduct.profile.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Profile","profile",NewProductService.requestCandidateProfile,
	      NewProductService.transferToAnotherProfile,"anotherProfileId",newProduct.profile?newProduct.profile.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{ moment(newProduct.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(newProduct,targetComponent)}
      </DescriptionList>
	)

}


class NewProductDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'newProduct'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.newProduct
    if(!this.props.newProduct.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"New Product",cardsFor: "newProduct",
    	cardsSource: this.props.newProduct,returnURL,displayName,
  		subItems: [
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  newProduct: state._newProduct,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(NewProductDashboard))

