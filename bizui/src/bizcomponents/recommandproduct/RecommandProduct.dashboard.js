

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
import styles from './RecommandProduct.dashboard.less'
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


const imageList =(recommandProduct)=>{return [
	   {"title":'Product Cover Image',"imageLocation":recommandProduct.productCoverImage},
]}

const internalImageListOf = (recommandProduct) =>defaultImageListOf(recommandProduct,imageList)

const optionList =(recommandProduct)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (recommandProduct) =>defaultSettingListOf(recommandProduct, optionList)
const internalLargeTextOf = (recommandProduct) =>{

	return(<div> 
   <Card title={`Remark`} ><pre>{recommandProduct.remark}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (recommandProduct,targetComponent) =>{
	
	
	const {RecommandProductService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{recommandProduct.id}</Description> 
<Description term="Name">{recommandProduct.name}</Description> 
<Description term="Parent Category">{recommandProduct.parentCategory==null?appLocaleName(userContext,"NotAssigned"):recommandProduct.parentCategory.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Parent Category","levelNCategory",RecommandProductService.requestCandidateParentCategory,
	      RecommandProductService.transferToAnotherParentCategory,"anotherParentCategoryId",recommandProduct.parentCategory?recommandProduct.parentCategory.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Brand">{recommandProduct.brand==null?appLocaleName(userContext,"NotAssigned"):recommandProduct.brand.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Brand","brand",RecommandProductService.requestCandidateBrand,
	      RecommandProductService.transferToAnotherBrand,"anotherBrandId",recommandProduct.brand?recommandProduct.brand.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Origin">{recommandProduct.origin}</Description> 
<Description term="Catalog">{recommandProduct.catalog==null?appLocaleName(userContext,"NotAssigned"):recommandProduct.catalog.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Catalog","catalog",RecommandProductService.requestCandidateCatalog,
	      RecommandProductService.transferToAnotherCatalog,"anotherCatalogId",recommandProduct.catalog?recommandProduct.catalog.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{ moment(recommandProduct.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Profile">{recommandProduct.profile==null?appLocaleName(userContext,"NotAssigned"):recommandProduct.profile.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Profile","profile",RecommandProductService.requestCandidateProfile,
	      RecommandProductService.transferToAnotherProfile,"anotherProfileId",recommandProduct.profile?recommandProduct.profile.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(recommandProduct,targetComponent)}
      </DescriptionList>
	)

}


class RecommandProductDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'recommandProduct'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.recommandProduct
    if(!this.props.recommandProduct.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Recommand Product",cardsFor: "recommandProduct",
    	cardsSource: this.props.recommandProduct,returnURL,displayName,
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
  recommandProduct: state._recommandProduct,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RecommandProductDashboard))

