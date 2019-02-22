
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'



const menuData = {menuName:"Recommand Product", menuFor: "recommandProduct",
  		subItems: [
  
  		],
}

const renderTextCell=(value, record)=>{
	const userContext = null
	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+appLocaleName(userContext,"Chars")+")"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${appLocaleName(userContext,"Currency")}${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{
	const userContext = null

	return  (value? appLocaleName(userContext,"Yes") : appLocaleName(userContext,"No"))

}

const renderReferenceCell=(value, record)=>{
	const userContext = null
	return (value ? value.displayName : appLocaleName(userContext,"NotAssigned")) 

}

const displayColumns = [
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Name', debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Parent Category', dataIndex: 'parentCategory', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Brand', dataIndex: 'brand', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Product Cover Image', dataIndex: 'productCoverImage', render: (text, record) => renderImageCell(text,record,'Product Cover Image') },
  { title: 'Origin', debugtype: 'string', dataIndex: 'origin', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Catalog', dataIndex: 'catalog', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Remark', debugtype: 'string', dataIndex: 'remark', width: '88',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Last Update Time', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: 'Profile', dataIndex: 'profile', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Platform', dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  parentCategory: 'Parent Category',
  brand: 'Brand',
  productCoverImage: 'Product Cover Image',
  origin: 'Origin',
  catalog: 'Catalog',
  remark: 'Remark',
  lastUpdateTime: 'Last Update Time',
  profile: 'Profile',
  platform: 'Platform',

}


const RecommandProductBase={menuData,displayColumns,fieldLabels}
export default RecommandProductBase



